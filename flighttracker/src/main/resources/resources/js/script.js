
/// <reference path="angular.js"/> 
var myApp=angular.module("myModule", ['ui.map', 'ui.event']).controller("myController", function($scope,$http){
	
	$scope.getFlight = function () {
        $http.get('/listFlight').
            success(function(data) {
                $scope.flights= data;
            });
    }
	
	$scope.createFlight = function () {
        $http.post('/createFlight',{flightPrefix:this.flightPrefix,flightNumber:this.flightNumber}).
            success(function(data) {
                $scope.flights= data;
            });
    }
	$scope.createFlights = function () {
        $http.post('/createFlightList',$scope.flights).
            success(function(data) {
                $scope.flights= data;
            });
    }
	
	$scope.deleteAll = function () {
        $http.post('/deleteAll').
            success(function(data) {
                $scope.flights= data;
            });
    }
	
	$scope.addRow = function(){	
		if(!angular.isDefined($scope.flights) || $scope.flights == ""){
			$scope.flights = [];
		}
		$scope.flights.push({ 'flightPrefix':'', 'flightNumber': ''});
		
	};
	

	
	$scope.showCreatePage=function(){
		$scope.template = $scope.templates[1];
		$scope.flights = [];
	};
	
	$scope.showSearchPage=function(){
		$scope.template = $scope.templates[0];
		$scope.getFlight();
	};
	
	$scope.showMap=function(){
		$scope.template = $scope.templates[2];
	};
	
	$scope.templates = [{
        name: 'searchFlight.html',
        url: 'searchFlight.html'},
    {
        name: 'createFlights.html',
        url: 'createFlights.html'},
        {
            name: 'map.html',
            url: 'map.html'}];
	$scope.template = $scope.templates[0];
});

myApp.directive('myMap', function() {
    // directive link function
    var link = function(scope, element, attrs) {
        var map, infoWindow;
        var markers = [];
        
        // map config
        var mapOptions = {
            center: new google.maps.LatLng(50, 2),
            zoom: 4,
            mapTypeId: google.maps.MapTypeId.ROADMAP,
            scrollwheel: false
        };
        
        // init the map
        function initMap() {
            if (map === void 0) {
                map = new google.maps.Map(element[0], mapOptions);
            }
        }    
        
        // place a marker
        function setMarker(map, position, title, content) {
            var marker;
            var markerOptions = {
                position: position,
                map: map,
                title: title,
                icon: 'img/' + title + '.png'
            };

            marker = new google.maps.Marker(markerOptions);
            markers.push(marker); // add marker to array
            
            google.maps.event.addListener(marker, 'click', function () {
                // close window if not undefined
                if (infoWindow !== void 0) {
                    infoWindow.close();
                }
                // create new window
                var infoWindowOptions = {
                    content: content
                };
                infoWindow = new google.maps.InfoWindow(infoWindowOptions);
                infoWindow.open(map, marker);
            });
        }
        
        // show the map and place some markers
        initMap();
        
        setMarker(map, new google.maps.LatLng(51.508515, -0.125487), 'EK0522', 'Just some content');
        setMarker(map, new google.maps.LatLng(52.370216, 4.895168), 'EK0523', 'More content');
        setMarker(map, new google.maps.LatLng(48.856614, 2.352222), 'EK0523', 'Text here');
    };
    
    return {
        restrict: 'A',
        template: '<div id="gmaps"></div>',
        replace: true,
        link: link
    };
});
