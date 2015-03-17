var PessoaProxy = {

	url : "api/pessoas",

	insert : function(pessoa) {
		return $.ajax({
			type : "POST",
			url : this.url,
			data : JSON.stringify(pessoa),
			contentType : "application/json"
		});
	},
	
	obter : function(id){
		return $.ajax({
			type : "GET",
			url : this.url + "/" + id
		});
	}
};
