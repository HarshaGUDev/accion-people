app.service('empService', [ '$http', '$log', function($http, $log) {
	this.findEmployeeByName = function(empName, url, cb) {
		$http({
			url : url + empName,
			method : 'GET'
		}).then(function(resp) {
			// $log.log(resp.data);
			cb(resp.data);
		}, function(resp) {
			$log.error("ERROR occurred");
		});
	};

} ]);
app.service('orgChart', [ '$http', '$log', function($http, $log) {
	this.getListOfEmp = function(url, cb) {
		$http({
			url : url,
			method : 'GET'
		}).then(function(resp) {
			// $log.log(resp.data);
			cb(resp.data);
		}, function(resp) {
			$log.error("ERROR occurred");
		});
	};
} ]);