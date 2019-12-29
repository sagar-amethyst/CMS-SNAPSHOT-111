
  setTimeout(function () {
        document.getElementById('alert').style.display='none';
    }, 1000);


/*$(function(){
	$("#updateClaimForm").submit(function(e){
		e.preventDefault();
		
	});
});


$(function() {
	$("#userList").click(function() {
		fetchList("user");
	});
	
	$("#addressList").click(function() {
		fetchList("address");
	});
});

function addForm(type) {
	modifyData(type+"/form");
}

function editForm(object) {
	alert(object);
	//modifyData(type+"/"+id);
}

function fetchList(type) {
	
	modifyData(type+"/list");
}

function modifyData(suffix) {
	alert(suffix);
	$.ajax({
		type : "GET",
		url : suffix,
		success : function(data) {
			alert(hi)
			console.log(data);
			$(".inline-jsp").html(data);
		},error:function(){
			console.log("error")
		}
	});
}

function deleteData(type, id) {
	toastr.warning("<div>Are you sure you want to delete this?</div>" +
			"<div class='btn-group pull-right'>" +
			"<button type='button' id='confirmationYes' class='btn btn-xs btn-default'><i class='glyphicon glyphicon-ok'></i> Yes</button>" +
			"<button type='button' class='btn btn-xs btn-default clear'><i class='glyphicon glyphicon-remove'></i> No</button>" +
			"</div>", "Delete Confirmation", {
		allowHtml:true,
		closeButton:true,
		onShown: function() {
			$("#confirmationYes").click(function() {
				$.ajax({
					type : "GET",
					url : "/mightyjava/"+type+"/delete/"+id,
					success : function(data) {
						fetchList(type);
						toastr.success(data.message, "Delete Confirmation", {
							closeButton:true
						});
					}
				});
			});
		}
	});
}

alert("displayClaimDetails")*/