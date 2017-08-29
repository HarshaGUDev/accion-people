var app = angular.module('EmployeeDetails', [ "ui.router" ]);
app.config([ '$stateProvider', '$urlRouterProvider','$httpProvider',
		function($stateProvider, $urlRouterProvider,$httpProvider) {
	     $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
			$stateProvider.state('empDetails', {
				url : '/empDetails/{empId}/{email}',
				templateUrl : '/js/views/get-details.html',
				controller : 'getEmpDetails'
			}).state('fullEmpDetails', {
				url : '/FullEmpDetails/{empId}/{email}',
				templateUrl : '/js/views/get-full-details.html',
				controller : 'getFullEmpDetails'
			}).state('search', {
				url : '/searchDetails/{name}/',
				templateUrl : '/js/views/search.html',
				controller : 'empSearch'

			}).state('designation', {
				url : '/getDesignation/{empId}/{designation}/{name}/{project}/{email}',
				templateUrl : '/js/views/managerOrgChart.html',
				controller : 'empDesignation'

			}).state('project', {
				url : '/getProject/{empId}/{project}/{name}/{email}',
				templateUrl : '/js/views/projectOrgChart.html',
				controller : 'empProject'

			}).state('report', {
				url : '/getReport/{empId}/{report}/{name}/{reportById}/{email}',
				templateUrl : '/js/views/reportOrgChart.html',
				controller : 'empReport'

			}).state('reload', {
				url : '/'
			})
		} ]);
// Creating the Angular Controller
app.controller('AppCtrl', function($http, $scope) {

	// method for getting user details
	var getUser = function() {
		$http({
			url : "/user",
			method : 'GET'
		}).then(function(resp) {
			$scope.resp =resp;
			console.log(resp.data.userAuthentication.authenticated);
			
		}, function(error) {
			$scope.resource = error;
		});
	};
	getUser();

	// method for logout
	$scope.logout = function() {
	
			$http({
				url : "/logout",
				method : 'POST'
			}).then(function(resp) {
				$scope.resp = null;
				
			}, function(error) {
				
				
			});
			
	};
});
