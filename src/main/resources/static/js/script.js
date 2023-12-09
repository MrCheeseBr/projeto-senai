$(document).ready(function () {
    $('.dynamic-update-rows').on('click', 'button[data-dynamic-update-rows-url]', function(){
        let url = $(this).data('dynamic-update-rows-url');

        let formData = $('form').serializeArray();
        let param = {};
        param["name"] = $(this).attr('name');
        param["value"] = $(this).val();
        formData.push(param);

        // Atualiaza a seção dinâmica
        $('#dynamicTableContents').load(url, formData);
        $('.cpf').mask('000.000.000-00');
        $('.telefone').mask('()00000-0000')
    });

    $('.dynamic-update-rows-turma').on('click', 'button[data-dynamic-update-rows-url-turma]', function () {
        let urlTurma = $(this).attr('data-dynamic-update-rows-url-turma');


        let formDataTurma = $('form').serializeArray();
        let param = {};
        param["name"] = $(this).attr('name');
        param["value"] = $(this).val();
        formDataTurma.push(param);


        // Atualiaza a seção dinâmica
        $('#dynamicTableContentsTurmas').load(urlTurma, formDataTurma);

    });

    function atualizarIdTurma(indice,e) {
        var idTurma = e.options[e.selectedIndex].value;

        document.getElementById('turma' + indice + '.id').value = idTurma;

        $('#turmas' + indice + '.id').val(idTurma);
    }
});