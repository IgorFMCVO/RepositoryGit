package appEstoquePlus.controller;


import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;

import appEstoquePlus.model.domain.Funcionario;
import appEstoquePlus.model.service.FuncionarioService;
import spark.Route;

public class FuncionarioController {

	
	//recuperar todos funcionarios
	public static Route obterLista = (req, res) -> {
		
		return FuncionarioService.obterLista();
	/*return	new ArrayList<Funcionario>(
				Arrays.asList(
						new Funcionario(),
						new Funcionario("Andre"),
						new Funcionario("kleber"),
						new Funcionario("Maria")
											
				)
			);*/

		//return "Listagem de funcionários";
	};
	
	//incluir novo funcionario
	public static Route incluir = (req, res) -> {
		//String oNome = req.params("oNome");
	
		Funcionario funcionario = new Gson().fromJson(req.body(), Funcionario.class);
		
		FuncionarioService.incluir(funcionario);
		
		return "Inclusão de funcionários realizada com sucesso: " + funcionario +"!";
	};
	
	//excluir um funcionario
	public static Route excluir = (req, res) -> {
		Integer index = Integer.valueOf(req.params("id"));
		Funcionario funcionario = FuncionarioService.obterPorId(index);
		FuncionarioService.excluir(index);
			return "Exclusão de funcionários realizada com sucesso: " + funcionario + "!";
	};
		
	//recuperar um funcionario
	public static Route obter = (req, res) -> {
		Integer index = Integer.valueOf(req.params("id"));
		Funcionario funcionario = FuncionarioService.obterPorId(index);		
				return "Recuperção realizada com sucesso: " + funcionario + "!";
	};
}
