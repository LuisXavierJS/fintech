package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWTSigner;

import model.Usuario;
import repository.UsuarioRepository;


@RestController
@RequestMapping("/user")
public class UsuarioCtrlr {
	UsuarioRepository userRep = new UsuarioRepository();

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@RequestBody Map<String,Object> payload){
		
		String username = (String) payload.get("username");
		String password = (String) payload.get("password");
		
		Usuario user;
		
		try{
			user = userRep.recuperarUsuarioPorNomeESenha(username, password);
		}catch(Exception e){
			return "{\"code\":500,\"type\":\"Ocorreu um erro interno no servidor\"}";
		}
		
		if(user != null){
			//retorna token
			String segredo = "secu"+user.getId_usuario()+"rity";
			JWTSigner token = new JWTSigner(segredo);
			HashMap<String,Object> reividicacoes = new HashMap<String,Object>();
			reividicacoes.put("site", "fintech_faeterj.com");
			reividicacoes.put("dono", user.getNome_completo());
			return "{\"code\":200,\"token\":"+token.sign(reividicacoes)+"}";
		}else{
			//retorna bad authentication
			return "{\"code\":403,\"type\":\"Credenciais erradas!\"}";
		}
	}
	

	@RequestMapping(value="/cadastrar",method= RequestMethod.POST )
	public String cadastrar(@RequestBody Map<String,Object> payload){
		return "tentou cadastrar";
	}
	
}
