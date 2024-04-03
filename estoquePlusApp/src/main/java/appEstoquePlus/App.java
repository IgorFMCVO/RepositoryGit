package appEstoquePlus;
import appEstoquePlus.controller.FuncionarioController;
import appEstoquePlus.controller.UsuarioController;
import appEstoquePlus.controller.ViaCepController;
//import appEstoquePlus.model.domain.Usuario;
import spark.Spark;

public class App {
	public static void main(String[] args) {
		
		Spark.port(8080);
		
		Spark.get("/", (req, res) -> {
			//return "teste de lambda";Chamada para o teste inicial de funcionamento
			return App.class.getResourceAsStream("/index.html");
			} );// chamará o index
		
		//System.out.println(new Usuario());
		//System.out.println(new Usuario("Exemplo de nome"));
		
		//Vamos utilizar o methodo de criar usuario através do Route em UsuarioController
		Spark.get("/usuario", new UsuarioController());
		
		//Rota para funcionário
		Spark.get("/funcionario/lista", FuncionarioController.obterLista);
		//Spark.get("/funcionario/:nome/incluir", FuncionarioController.incluir);
		Spark.post("/funcionario/incluir", FuncionarioController.incluir);
		Spark.delete("/funcionario/:id/excluir", FuncionarioController.excluir);
		Spark.get("/funcionario/:id", FuncionarioController.obter);
		
		
		Spark.get("/viacep/:cep", ViaCepController.getAdress);
	}

}
