 /********************* Edit Compte********************************/
   function loadCompte(field){ //open modal
   		var data = field.closest("td").id;
   		$('#ribEdit').val(data);
    	$('#clientEdit').val($('#client' + data).text());
    	$('#soldeEdit').val($('#solde' + data).text());
    	$('#edit-compte-modal').modal('show');
    }
    $( "#compte-edit-form" ).submit(function(event ) { //edit action
    	event.preventDefault();
    	var data = $('#ribEdit').val();
    	$.ajax({
			url : '/admin/update_compte',
			type : 'POST',
			data :  $("#compte-edit-form").serialize(),
			error: function (request, error) {
		        swal("ERROR!", " Can't do because: " + error, "error");
		    },
			success : function(response) {	
				$('#client' + data).text($('#clientEdit').val());
				$('#solde' + data).text($('#soldeEdit').val());
				
		    	$('#edit-compte-modal').modal('hide');
		    	swal("Updated!", "The account  has been updated.", "success");
			}
		});
    });
    /*********************New Compte********************************/
    function newCompte(){ //open modal
    	$('#clientNew').val('');
    	$('#soldeNew').val('');
    	$('#new-compte-modal').modal('show');
    }
    $( "#compte-new-form" ).submit(function(event ) { //add action
    	event.preventDefault();
    	$.ajax({
			url : '/admin/new_compte',
			type : 'POST',
			data :  $("#compte-new-form").serialize(),
			dataType: "text",
			error: function (request, error) {
		        swal("ERROR!", " Can't do because: " + error, "error");
		    },
			success : function(ribNewCompte) {	
				var client = $('#clientNew').val();
				var solde = $('#soldeNew').val();
				var nextRow = $('#dt_tableTools').DataTable().column( 0 ).data().length + 1;
		    	$('#new-compte-modal').modal('hide');
		    	var td1 ='<td><span>'+nextRow+'</span></td>' ;
		    	var td2 ='<td id="rib'+ribNewCompte+'">'+ribNewCompte+'</td>' ; 
		    	var td3 ='<td id="client'+ribNewCompte+'">'+client+'</td>' ; 
		    	var td4 ='<td id="solde'+ribNewCompte+'">'+solde+'</td>' ; 
		    	var td5 ='<td id="'+ribNewCompte+'">' +
							'<a href="#" onclick="loadCompte(this)" data-toggle="tooltip" data-original-title="Edit">' +
								'<i class="md-icon material-icons" data-toggle="modal" data-target="#edit-compte-modal">&#xE150;</i>' +
							'</a> &nbsp;' +
							'<a href="#" onclick="deleteCompte(this)" data-toggle="tooltip" data-original-title="Delete">' +
								'<i class="material-icons">&#xE5CD;</i>' +
							'</a>' +
						'</td>' ;
		    	
		    	$('#dt_tableTools').DataTable().row.add([td1,td2,td3,td4,td5 ]).draw();
		    	swal("Créer!", "Le compte a été créé.", "success");
			}
		});
    });
    
    /********************* Delete Compte********************************/ 
   function deleteCompte(field){
   var data = field.closest("td").id;
        swal({   
            title: "Are you sure?",   
            text: "You will not be able to recover this account!",   
            type: "warning",   
            showCancelButton: true,   
            confirmButtonColor: "#DD6B55",   
            confirmButtonText: "Yes, delete it!",   
            closeOnConfirm: false 
        }, function(){ 
    		$.ajax({
    			url : '/admin/delete_compte',
    			type : 'POST',
    			data : {
    				rib : data
    			},
    			error: function (request, error) {
    				 swal("ERROR!", " Can't do because: " + error, "error");
    		    },
    			success : function(response) {	
    				$('#dt_tableTools').DataTable().row( $(field).closest('tr') ).remove().draw();
    				//field.closest('tr').remove(); 
    				//$('#myTable').dataTable();
    				swal("Deleted!", "The account has been deleted.", "success"); 
    				
    			}
    		})
           
        });
   }
