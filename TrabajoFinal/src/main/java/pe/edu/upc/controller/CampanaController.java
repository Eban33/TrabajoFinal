
package pe.edu.upc.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entity.Campana;
import pe.edu.upc.service.ICampanaService;

@Controller
@RequestMapping("/campanas")
public class CampanaController {
	
	@Autowired
	private ICampanaService campService;
	@RequestMapping("/bienvenido")
	public String irBienvenido() {
		return "bienvenido";
	}
	@GetMapping("/nueva")
	public String nuevaCampana(Model model)
	{
		model.addAttribute("campana",new Campana());
		return "campana/campana";
	}
	@PostMapping("/guardar")
	public String guardarCampana(@Valid Campana campana,BindingResult result,Model model,SessionStatus status)
		throws Exception{
			if(result.hasErrors()) {
				return "/campana/campana";
			}else {
				int rpta = campService.insertar(campana);
				if (rpta > 0) {
					model.addAttribute("mensaje", "Ya existe");
					return  "/campana/campana";
				} else {
					model.addAttribute("mensaje", "Se guardó correctamente");
					status.setComplete();
			}
			model.addAttribute("listaCampanas", campService.listar());

			return "/campana/listaCampana";
		}
			}

	@GetMapping("/listar")
	public String listarCampanas(Model model) {
		try {
			model.addAttribute("campan"
					+ "a",new Campana());
			model.addAttribute("listaCampanas",campService.listar());
		} catch(Exception e) {
			model.addAttribute("error",e.getMessage());
		}
		return "/campana/listaCampana";
	}
	@GetMapping("/detalle/{id}")
	public String detailsCampana(@PathVariable(value="id") int id,Model model) {
		try {
			Optional<Campana> campana= campService.listarId(id);
			if(!campana.isPresent()) {
				model.addAttribute("info","Campaña no existe");
				return "redirect:/campanas/listar";
			}else {
				model.addAttribute("campana",campana.get());
			}
		}
		catch(Exception e){
			model.addAttribute("error",e.getMessage());
		}
		return "/campana/campana";
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String,Object> model,@RequestParam(value="id") Integer id) {
		try {
			if(id !=null && id>0) {
				campService.eliminar(id);
				model.put("mensaje","Se eliminó correctamente");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje","No se puede eliminar una Campaña");
			
		}
		model.put("listaCampanas",campService.listar());
		return "redirect:/campanas/listar";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String,Object> model,@ModelAttribute Campana campana) throws ParseException{
		
		List<Campana> listaCampanas;
		
		campana.setNombreCampana(campana.getNombreCampana());
		listaCampanas=campService.buscarNombre(campana.getNombreCampana());
		
		if(listaCampanas.isEmpty()) {
			model.put("mensaje","No sé encontró");
		}
		model.put("listaCampanas", listaCampanas);
		return "campana/listaCampana";
	}
	

}
