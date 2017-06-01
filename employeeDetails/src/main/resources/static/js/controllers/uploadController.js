app.controller('searchEmp', [ '$scope', '$state', 'empService',
		function($scope, $state, empService) {
			$scope.doSearch = function() {
				$state.go('search', {
					name : $scope.name
				}, {
					reload : true
				});
			};
			$scope.reload = function() {
				$location.path('/people')
			}

		} ]);
app.controller('empSearch', [ '$scope', '$state', 'empService',
		function($scope, $state, empService) {
			$scope.showDetails = false;
			var url = '/accionlabs/search/';
			if ($scope.name != null) {
				empService.findEmployeeByName($scope.name, url, function(r) {
					$scope.empList = r;

					if (r.length === 0) {
						$scope.showDetails = true;
					}

				})
			}
		} ]);

app.controller('getEmpDetails', function($scope, $stateParams, $http,
		empService) {
	$scope.id = $stateParams.empId;
	var url = '/accionlabs/emp/details/';
	empService.findEmployeeByName($stateParams.empId, url, function(r) {
		$scope.empDetailList = r;

	})

});

app.controller('getFullEmpDetails', function($scope, $stateParams, $http,
		empService) {

	$scope.id = $stateParams.empId;

	var url = '/accionlabs/emp/fulldetails/';
	empService.findEmployeeByName($stateParams.empId, url, function(r) {

		$scope.empFullDetailList = r;

	});
	$scope.doTheBack = function() {
		window.history.back();
	};
});
app.filter('customNumber', function() {
	return function(value) {
		return parseInt(value, 10) // convert to int
	}
})

app.filter('FilterNumber', function() {
	return function(value) {
		if (value != undefined)
			return value.replace(/[^a-zA-Z ]/g, "") // convert to int
	}
})

app.controller('empDesignation', function($scope, $stateParams, $http,
		orgChart, $state) {
	$scope.name = $stateParams.name;
	$scope.id = $stateParams.empId;
	$scope.designation = $stateParams.designation;
	$scope.project = $stateParams.project;

	var url = '/accionlabs/emp/details/' + $stateParams.empId + '/designation';
	orgChart.getListOfEmp(url, function(r) {
		$scope.empOrgChart = r;

	});

});
app.controller('empProject', function($scope, $stateParams, $http, orgChart,
		$state) {
	$scope.name = $stateParams.name;
	$scope.id = $stateParams.empId;
	$scope.project = $stateParams.project;

	var url = '/accionlabs/emp/details/' + $stateParams.empId + '/project';
	orgChart.getListOfEmp(url, function(r) {
		$scope.empOrgChart = r;
		console.log(r);
	});

});
app.controller('empReport', function($scope, $stateParams, $http, orgChart,
		$state) {
	$scope.name = $stateParams.name;
	$scope.id = $stateParams.empId;
	$scope.report = $stateParams.report;
	$scope.reportById = $stateParams.reportById;

	var url = '/accionlabs/emp/details/' + $stateParams.empId + '/manager';
	orgChart.getListOfEmp(url, function(r) {

		$scope.empOrgChart = r;

	});

});
