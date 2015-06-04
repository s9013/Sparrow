define(['angular'],function(){

	'use strict';

	// show controller module
	var showController = angular.module('Show', []);

	// show controller
	showController.controller('showCtrl',['$scope','httpService',function($scope,httpService){

	$scope.page = 1;	
		
	// user requirejs import mosonry bridget imagesloaded
	requirejs([
			'jquery',
			'vender/masonry.pkgd',
			'vender/imagesloaded.pkgd',
			'vender/jquery.bridget'],
			function($,Masonry){
				// make Masonry a jQuery plugin
				$.bridget( 'masonry', Masonry );
				// now you can use $().masonry()
				var html = '';
				
				httpService.querywithParams('get','api/image/getImages',{page:$scope.page,size:15}).then(function(data){
				 	console.log(data);
				 	$scope.images = data.data;

				    for ( var i = 0; i < $scope.images.length; i++ ) {
				    	var image = $scope.images[i];
				         html += '<div class="item"><div class="pic"><img src="api/file/getById?id='+image.path+'" > </div> <div class="text">'+ image.summary +'</div>  </div>';
				    }
				    $('#container').html(html);
				    $('#container').imagesLoaded( function(){
						$('#container').masonry({
						    itemSelector : '.item',
						    columnWidth: 260,
						    gutter:10,
						    isFitWidth:true
						});
					});
				});
					

				function addItems(){
					  $scope.page = $scope.page + 1;
				      var elems = [];
				      var fragment = document.createDocumentFragment();
				      httpService.querywithParams('get','api/image/getImages',{page:$scope.page,size:15}).then(function(data){
						 	console.log(data);
						 	$scope.images = data.data;
	
//						 	if($scope.images.length == 0){
//						 		alert('no data');
//						 		$scope.page = $scope.page - 1;
//						 		return;
//						 	}
						 	
						    for ( var i = 0; i < $scope.images.length; i++ ) {
						    	var image = $scope.images[i];
						        var elem = $( '<div class="item"><div class="pic"><img src="api/file/getById?id='+image.path+'" > </div> <div class="text">'+ image.summary +'</div>  </div>')[0]; //getItemElement();
							    fragment.appendChild( elem );
							    elems.push( elem );
						    }
						    
						    // append elements to container
						    container.appendChild( fragment );
						    // add and lay out newly appended elements
						    // msnry.appended( elems );
						    $('#container').imagesLoaded( function(){
						      	$('#container').masonry( 'appended', elems);
						    });
						    
						});
				  }

			  // scroll
			  window.onscroll = function() { 
			    if($(window).scrollTop()!==0 && $(document).height() == $(window).scrollTop()+ $(window).height()){
			      addItems();
			    }
			  };

			}
);
			
			$('#container').on('click','.item',function(){
			  	console.log(this);
			  	$scope.showImgPath = $(this).find('img').attr('src');
			  	$scope.$apply();// tip
			  	$('#showModal').modal();	  	
			});

/*		// scroll event
		window.onscroll = function() { 
		   if($(document).height() == $(window).scrollTop()+ $(window).height()){
		        httpService.querywithParams('data/images.json',null,true).then(function(data){
			 		$scope.images = $scope.images.concat(data);
				});
		    }
		};*/
	}]);





//	// show controller
//	showController.controller('show2Ctrl',['$scope','iWayHttpService','$sce','$routeParams',function($scope,iWayHttpService,$sce,$routeParams){
//			console.log($routeParams.id);
//
//			iWayHttpService.querywithParams('data/images.json',null).then(function(data){
//				console.log(data);
//				for(var i=0;i< data.length; i++){
//					if($routeParams.id == data[i].id){
//						$scope.image =data[i];
//					}
//				}			 	
//			});
//			
//
//
//	}]);

});// end for define
