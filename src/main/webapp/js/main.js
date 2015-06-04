require.config({

	baseUrl:'.',

	paths:{
		'jquery': 'vender/jquery/jquery',
		'bootstrap': 'vender/bootstrap/bootstrap',
		'angular' : 'vender/angularjs/angular',
		'angular-upload' : 'vender/angularjs/angular-file-upload.min',
		'route':'vender/angular-route/angular-route',
		'resource':'vender/angular-resource',
		'domReady':'vender/domReady',
		'echarts':'vender/echarts/echarts-plain',
		'nicescroll':'vender/nicescroll/jquery.nicescroll',
		"angular-bootstrap":'vender/ui-bootstrap-0.13.1-SNAPSHOT',
		'ckeditor':'vender/ckeditor/ckeditor'
	},

	shim:{
		'bootstrap':{
			deps:['jquery']
		},
		"route":{
      		deps:['angular']  		
  		},
  		"resource":{
      		deps:['angular']  		
  		},
  		"angular-bootstrap":{
      		deps:['angular']  		
  		},
  		"angular-upload":{
      		deps:['angular']  		
  		}
	}

});

require(['domReady','angular','js/app','jquery','bootstrap','nicescroll','angular-upload'],function (domReady) {

	// start angular
	domReady(function(){
		angular.bootstrap(document,['App']);

		// scroll
		$("html").niceScroll({cursorcolor:"#F00",cursoropacitymax:0.7,boxzoom:false,touchbehavior:false});
		// fix navbar
	 	$('.collapse li').on('click',function(){
	 		$(this).parents('ul').find('li').removeClass('active');
	 		$(this).addClass('active');
            $('[data-toggle=collapse]:visible').click();   
         });


	 	 // show hide back
     $(window).scroll(function(){  
         if(window.scrollY > 0){
             $('#back').fadeIn(100);
         }else{
             $('#back').fadeOut(500); 
         } 
     });
     
     // back
     $('#back').on('click',function(){
         //console.log(window.scrollTop );
         //$('body').attr('scrollTop','0');
         $('body,html').animate({scrollTop:0},500);
         //$('#back').fadeOut(10);
     });
     
	});

	

});