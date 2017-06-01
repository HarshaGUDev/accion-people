var app = angular.module('EmployeeDetails', [ "ui.router" ]);
app.config([ '$stateProvider', '$urlRouterProvider',
		function($stateProvider, $urlRouterProvider) {

			$stateProvider.state('empDetails', {
				url : '/empDetails/{empId}/',
				templateUrl : '/js/views/get-details.html',
				controller : 'getEmpDetails'
			}).state('fullEmpDetails', {
				url : '/FullEmpDetails/{empId}',
				templateUrl : '/js/views/get-full-details.html',
				controller : 'getFullEmpDetails'
			}).state('search', {
				url : '/searchDetails/{name}/',
				templateUrl : '/js/views/search.html',
				controller : 'empSearch'

			}).state('designation', {
				url : '/getDesignation/{empId}/{designation}/{name}/{project}',
				templateUrl : '/js/views/managerOrgChart.html',
				controller : 'empDesignation'

			}).state('project', {
				url : '/getProject/{empId}/{project}/{name}/',
				templateUrl : '/js/views/projectOrgChart.html',
				controller : 'empProject'

			}).state('report', {
				url : '/getReport/{empId}/{report}/{name}/{reportById}',
				templateUrl : '/js/views/reportOrgChart.html',
				controller : 'empReport'

			}).state('reload', {
				url : '/'
			})
		} ]);
