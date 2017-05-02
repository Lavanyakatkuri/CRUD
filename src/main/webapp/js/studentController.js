'use strict';

angular
		.module('myApp', [])
		.controller(
				'studentController',
				[
						'$scope',
						'$http',
						function($scope, $http) {

							$scope.editingData = {};
							$scope.student = {}

							$scope.val = false;
							$scope.addStudent = function() {
								$scope.val = true;

							}

							$scope.addNewStudent = function(stuID, firstName,
									lastName, email) {

								$scope.student = {
									stuNo : stuID,
									stufName : firstName,
									stulName : lastName,
									stuEmail : email
								};

								$http({
									method : 'POST',
									url : "rest/students/add",
									data : $scope.student
								})
										.success(
												function(data, status, headers,
														config) {
													$scope.studentData = data;
													console
															.log($scope.studentData);
												});
							}

							$scope.getStudents = function() {

								$http({
									method : 'GET',
									url : "rest/students"
								})
										.success(
												function(data, status, headers,
														config) {
													$scope.studentData = data;
													console
															.log($scope.studentData);

													for (var i = 0, length = $scope.student.length; i < length; i++) {
														$scope.editingData[$scope.student[i].id] = false;
														console
																.log($scope.student.length);
													}

													$scope.modify = function(
															student) {
														$scope.editingData[student.id] = true;
													};

													$scope.update = function(
															student) {
														$scope.editingData[student.id] = false;
													};

												});
							}

							$scope.updateStudent = function(stuID) {
								console.log($scope.student);

								$http({
									method : 'PUT',
									url : "rest/students",
									data : $scope.student
								})
										.success(
												function(data, status, headers,
														config) {
													$scope.studentData = data;
													console
															.log($scope.studentData);

												})

							}
							$scope.deleteStudent = function(stuID) {

								$http({
									method : 'DELETE',
									url : "rest/students/delete/" + stuID
								})
										.success(
												function(data, status, headers,
														config) {

													$scope.getStudents();

												});
							};

							$scope.getStudents();

						} ]);
