package appEstoquePlus.controller;

import appEstoquePlus.model.domain.Usuario;
import spark.Request;
import spark.Response;
import spark.Route;

public class UsuarioController implements Route {

	@Override
	//public Object handle(Request request, Response response) throws Exception {
		// TODO Auto-generated method stub
		//return new Usuario();
	
	
	/*2- public String handle(Request request, Response response) throws Exception {
		StringBuilder html = new StringBuilder();
		html.append("- Usuário: ").append("....");
		html.append(new Usuario());
		html.append(" Fim do cadastro!");
		return html.toString();/*
		
		//1-Reitrado o trecho do index html
		/*<ul class="nav navbar-nav">
	      <li class="active"><a href="#">Home</a></li>
	      <li><a href="/usuario">Usuários</a></li>
	      
	    </ul>*/
	public String handle(Request request, Response response) throws Exception {
		StringBuilder html = new StringBuilder();
		
		// 5- html.append(new Usuario());
		
		// 4- html.append("<ul> <li><a href='/'>Voltar</a></li> </ul>");
	// 6- html.append("<a href='/'>" + new Usuario() + "</a>");
		Usuario usuario = new Usuario();
		html.append(usuario);
		html.append("<a href='/'> Voltar, " + usuario.getNome() + "?</a>");
		
		return html.toString();
		
	   // 3- <ul> <li><a href="/">Voltar</a></li> </ul>
	}
}
