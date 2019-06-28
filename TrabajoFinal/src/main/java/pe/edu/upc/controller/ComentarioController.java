package pe.edu.upc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entity.Comentario;
import pe.edu.upc.service.IClienteService;
import pe.edu.upc.service.IComentarioService;
import pe.edu.upc.service.IProductoService;

@Controller
@RequestMapping("/comentarios")
public class ComentarioController {

	@Autowired
	private IComentarioService coService;
	
	@Autowired
	private IProductoService pService;
	
	@Autowired
	private IClienteService cService;
	
	@GetMapping("/bienvenido")
	public String bienvenido(Model model) {
		return "bienvenido";
	}
	
	@GetMapping("/nuevo")
	public String nuevoProducto(Model model) {
		model.addAttribute("comentario", new Comentario());
		model.addAttribute("listaProductos", pService.listar());
		model.addAttribute("listaClientes",cService.listar());
		return "comentario/comentario";
	}

	@PostMapping("/guardar")
	public String guardarComentario(@ModelAttribute @Valid Comentario comentario, BindingResult result, Model model,
			SessionStatus status) throws Exception {
		if(result.hasErrors()){
			model.addAttribute("listaProductos", pService.listar());
			model.addAttribute("listaClientes", cService.listar());
			return "/comentario/comentario";
		} else {
		
        coService.insertar(comentario);
	
			model.addAttribute("mensaje", "Se guardó correctamente");
			status.setComplete();
		
		}
model.addAttribute("listaComentarios",coService.listar());
	return "redirect:/productos/ver/"+comentario.getProducto().getIdProducto();
//return "/comentario/comentario";
	}
	@GetMapping("/listar")
	public String listarProductos(@ModelAttribute @Valid Comentario comentario,Model model) {
		try {
			model.addAttribute("comentario", new Comentario());
			model.addAttribute("listaComentarios", coService.listar());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "redirect:/productos/ver/"+comentario.getProducto().getIdProducto();
	}

}
