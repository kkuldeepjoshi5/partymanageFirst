(function(define) {
	"use strict";

	define(
			[],
			function() {

				var EventCtrl = function($scope, $location, $state, $rootScope, i18nNotifications) {
					$scope.redirect=function(contact){
						$scope.setBG(contact);
						$location.path(contact);
					};

				};
				return [ '$scope', '$location', '$state', '$rootScope', 'i18nNotifications', EventCtrl ];
			});

}(define));