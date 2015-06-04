define(['angular',"route",
	'js/directive/directive',
	'js/home/controller','js/home/directive',
	'js/article/controller','js/article/directive',
	'js/timeline/controller',
	'js/show/controller','js/show/directive',
	'js/service/service',
	'js/upload/controller'
	],function(){

	'use strict';

	// define app module
	var appModule = angular.module('App', ['ngRoute','angularFileUpload',
		'Timeline','Show','homeDirectiveModule','ShowDirectiveModule','Upload',
		'ArticleCtrl','httpService','articleDirectiveModule'
		]);

	// app module config
	appModule.config(['$routeProvider','$locationProvider',
		function($routeProvider,$locationProvider) {

			$locationProvider.html5Mode(false).hashPrefix('~');

			$routeProvider
				.when("/home",{
									templateUrl : "./js/home/home.html",
									//controller : 'ChartCtrl',
									reloadOnSearch : false
							  }
				)
				.when("/timeline",{
									templateUrl : "./js/timeline/timeline.html",
									controller : 'timelineCtrl',
									reloadOnSearch : false
								  }
				)
				.when("/article",{
									templateUrl : "./js/article/article.html",
									controller : 'articleCtrl',
									reloadOnSearch : false
								 }
				).when("/articleDetail/:id",{
									templateUrl : "./js/article/articleDetail.html",
									controller : 'articleDetailCtrl',
									reloadOnSearch : false
								 }
				).when("/newArticle",{
									templateUrl : "./js/article/newArticle.html",
									controller : 'newArticleCtrl',
									reloadOnSearch : false
								 }
				)
				.when("/show",{
									templateUrl : "./js/show/show.html",
									controller : 'showCtrl',
									reloadOnSearch : false
							  }
				)
				.when("/about",{
									templateUrl : "./js/about/about.html",
									//controller : 'HelloCtrl',
									reloadOnSearch : false
								}
				).when("/upload",{
									templateUrl : "./js/upload/upload.html",
									controller : 'uploadCtrl',
									reloadOnSearch : false
								}
				)
				.otherwise({
						redirectTo : "/home"
				});
			}]).run([ "$rootScope", "$window", function($rootScope, $window) {

						$rootScope.$on('$locationChangeSuccess', function(){

							if(arguments[1].indexOf('plan') !== -1){
								scroll(0,450);
					        }else{
					        	scroll(0,0);
					        }  
							
						});  
					} ]);

});