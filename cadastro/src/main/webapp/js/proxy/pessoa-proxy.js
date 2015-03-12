var PessoaProxy = {

	url : "api/pessoas",

	insert : function(pessoa) {
		return $.ajax({
			type : "POST",
			url : this.url,
			data : JSON.stringify(pessoa),
			contentType : "application/json"
		});
	}
};
