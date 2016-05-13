
/// <reference path="angular.js"/> 
var myApp=angular.module("myModule", []).controller("myController", function($scope,$http){
	
	$scope.getFlight = function () {
        $http.get('http://localhost:8080/flight').
            success(function(data) {
                $scope.flights= data;
            });
    }
});
