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
	$scope.count=0;
	var url = '/accionlabs/emp/details/' + $stateParams.empId + '/designation';
	orgChart.getListOfEmp(url, function(r) {
		$scope.empOrgChart = r;
		console.log($scope.empOrgChart);
		console.log($scope.empOrgChart[1].length);
		for (i = 0; i < $scope.empOrgChart[1].length; i++) { 
			$scope.count=$scope.count+$scope.empOrgChart[1][i].empProjectList.length;
		}
		console.log($scope.count);
	});
	

});
app.controller('empProject', function($scope, $stateParams, $http, orgChart,
		$state) {
	$scope.name = $stateParams.name;
	$scope.id = $stateParams.empId;
	$scope.project = $stateParams.project;
	$scope.countHigherLevel=0;
	$scope.countLowerlevel=0;
	$scope.count=0;
	var url = '/accionlabs/emp/details/' + $stateParams.empId + '/project';
	orgChart.getListOfEmp(url, function(r) {
		$scope.empOrgChart = r;
		console.log($scope.empOrgChart);
//		if($scope.empOrgChart<2){
		$scope.countHigherLevel=$scope.empOrgChart.listOfProjectEmp.length;
		for (i = 0; i < $scope.countHigherLevel; i++) { 
			$scope.countLowerlevel=$scope.countLowerlevel+$scope.empOrgChart.listOfProjectEmp[i].listOfProjectEmp.length;
		}
		
		$scope.count=$scope.countHigherLevel+$scope.countLowerlevel;
		
/*		else{
			$scope.countHigherLevel1=$scope.empOrgChart[0].listOfProjectEmp.length;
			$scope.countLowerlevel1=0;
			$scope.countHigherLevel2=$scope.empOrgChart[1].listOfProjectEmp.length;
			$scope.countLowerlevel2=0;
				for(i=0;i<$scope.empOrgChart[0].listOfProjectEmp.length;i++){
					$scope.countLowerlevel1=$scope.countLowerlevel1+empOrgChart[0].listOfProjectEmp[i].listOfProjectEmp.length;
				}
				
				for(i=0;i<$scope.empOrgChart[1].listOfProjectEmp.length;i++){
					$scope.countLowerlevel2=$scope.countLowerlevel1+empOrgChart[1].listOfProjectEmp[i].listOfProjectEmp.length;
				}
			
		}*/
	});

});
app.controller('empReport', function($scope, $stateParams, $http, orgChart,
		$state) {
	$scope.name = $stateParams.name;
	$scope.id = $stateParams.empId;
	$scope.report = $stateParams.report;
	$scope.reportById = $stateParams.reportById;
	$scope.count=0;
	var url = '/accionlabs/emp/details/' + $stateParams.empId + '/manager';
	orgChart.getListOfEmp(url, function(r) {
		$scope.empOrgChart = r;
		console.log($scope.empOrgChart);
		console.log($scope.empOrgChart.length);
		console.log($scope.empOrgChart[0].length);
		for (i = 0; i < $scope.empOrgChart[0].length; i++) { 
			$scope.count=$scope.count+$scope.empOrgChart[0][i].empProjectList.length;
		}
		console.log($scope.count);

	});

});
