$(document).ready(function() {
    var tipoSelect = $("#tipo");
    var especialidadeField = $("#especialidadeField");
    var listaCadastrados = $("#listaCadastrados");
    var clienteSelect = $("#cliente");
    var especialistaSelect = $("#especialista");
    var listaConsultas = $("#listaConsultas");

    tipoSelect.change(function() {
        especialidadeField.toggle(this.value === 'especialista');
    });

    $("#cadastroForm").submit(function(event) {
        event.preventDefault();
        var formData = $(this).serialize();
        $.post("/cadastro", formData, function() {
            alert("Cadastro realizado com sucesso!");
            listarCadastrados();
            carregarClientesEspecialistas();
        }).fail(function() {
            alert("Falha ao realizar o cadastro.");
        });
    });

    function listarCadastrados() {
        $.ajax({
            url: "/listar-cadastrados",
            method: "GET",
            success: function(data) {
                listaCadastrados.empty();
                $.each(data.clientes, function(i, cliente) {
                    var clienteHtml = `<div class="card">
                        <div class="card-body">
                            <h5 class="card-title">${cliente.nome} - Cliente</h5>
                            <button class="btn btn-danger btn-sm" onclick='deletarCadastrado("${cliente.id}")'>Deletar</button>
                        </div>
                    </div>`;
                    listaCadastrados.append(clienteHtml);
                });
                $.each(data.especialistas, function(i, especialista) {
                    var especialistaHtml = `<div class="card">
                        <div class="card-body">
                            <h5 class="card-title">${especialista.nome} - Especialista</h5>
                            <button class="btn btn-danger btn-sm" onclick='deletarCadastrado("${especialista.id}")'>Deletar</button>
                        </div>
                    </div>`;
                    listaCadastrados.append(especialistaHtml);
                });
            }
        });
    }

    function carregarClientesEspecialistas() {
        $.ajax({
            url: "/listar-cadastrados",
            method: "GET",
            success: function(data) {
                clienteSelect.empty();
                especialistaSelect.empty();
                clienteSelect.append(`<option value=''>Selecione um Cliente</option>`);
                especialistaSelect.append(`<option value=''>Selecione um Especialista</option>`);
                $.each(data.clientes, function(i, cliente) {
                    clienteSelect.append(`<option value='${cliente.id}'>${cliente.nome}</option>`);
                });
                $.each(data.especialistas, function(i, especialista) {
                    especialistaSelect.append(`<option value='${especialista.id}'>${especialista.nome}</option>`);
                });
            }
        });
    }

    $("#consultaForm").submit(function(event) {
        event.preventDefault();
        var formData = $(this).serialize();
        $.post("/agendar-consulta", formData, function() {
            alert("Consulta agendada com sucesso!");
            listarConsultas();
        }).fail(function() {
            alert("Falha ao agendar a consulta.");
        });
    });

    function listarConsultas() {
        $.ajax({
            url: "/listar-consultas",
            method: "GET",
            success: function(data) {
                listaConsultas.empty();
                $.each(data, function(i, consulta) {
                    var consultaHtml = `<div class="card">
                        <div class="card-body">
                            <h5 class="card-title">${consulta.clienteNome} e ${consulta.especialistaNome}</h5>
                            <p class="card-text">${consulta.data} às ${consulta.hora}</p>
                            <button class="btn btn-warning btn-sm" onclick='cancelarConsulta("${consulta.id}")'>Cancelar</button>
                        </div>
                    </div>`;
                    listaConsultas.append(consultaHtml);
                });
            }
        });
    }

    window.deletarCadastrado = function(id) {
        $.ajax({
            url: `/deletar-cadastrado/${id}`,
            method: "DELETE",
            success: function() {
                alert("Cadastrado deletado com sucesso!");
                listarCadastrados();
                carregarClientesEspecialistas();
            }
        });
    };

    window.cancelarConsulta = function(id) {
        $.ajax({
            url: `/cancelar-consulta/${id}`,
            method: "DELETE",
            success: function() {
                alert("Consulta cancelada com sucesso!");
                listarConsultas();
            }
        });
    };

    listarCadastrados();
    carregarClientesEspecialistas();
    listarConsultas();
});
