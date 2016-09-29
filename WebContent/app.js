(function () {
    'use strict';

    angular
        .module('app', ['ngRoute', 'ngCookies','ngResource', 'ngMessages', 'ngAnimate', 'toastr', 'ui.router', 'satellizer','angucomplete-alt'])
        .config(config)
        .run(run);

    config.$inject = ['$routeProvider', '$locationProvider','$authProvider'];
    function config($routeProvider, $locationProvider,$authProvider) {
        $routeProvider
            .when('/', {
                controller: 'HomeController',
                //templateUrl: 'home/home.view.html',
                templateUrl: 'home/home.view.html',
                controllerAs: 'vm'
            })

            .when('/login', {
                controller: 'LoginController',
            	//controller: 'LoginCtrl',
                //templateUrl: 'login/login.view.html',
            	templateUrl: 'login/login.view.html',
                controllerAs: 'vm'
            })
            
            .when('/editprofile', {
                controller: 'UserProfleController',
                templateUrl: 'user/editprofile.view.html',
                controllerAs: 'vm'
            })
            
            .when('/profile', {
                controller: 'UserController',
                templateUrl: 'user/userprofile.view.html',
                controllerAs: 'vm'
            })
            
            .when('/about', {
                //controller: 'fileUploadCtl',
                templateUrl: 'menus/about.view.html',
                controllerAs: 'vm'
            })
            
            .when('/blog', {
                //controller: 'fileUploadCtl',
                templateUrl: 'menus/blog.view.html',
                controllerAs: 'vm'
            })
            
            .when('/oauthcallback', {
                //controller: 'RegisterController',
               // templateUrl: 'register/register.view.html',
            	templateUrl: 'login/oauthcallback.view.html',
                //controllerAs: 'vm'
            })
            

            .when('/register', {
                controller: 'RegisterController',
               // templateUrl: 'register/register.view.html',
            	templateUrl: 'register/register.view.html',
                controllerAs: 'vm'
            })

            .otherwise({ redirectTo: '/login' });
        
        /**
         *  Satellizer config
         */
        $authProvider.facebook({
          clientId: 'YOUR_FACEBOOK_APP_ID'
        });

        $authProvider.google({
          clientId: '197581381110-75bod9safpt93srogu625030372g1eib',
          url: 'Crewguru/crewdata/auth/google'
        });

        $authProvider.github({
          clientId: 'YOUR_GITHUB_CLIENT_ID'
        });

        $authProvider.linkedin({
          clientId: 'YOUR_LINKEDIN_CLIENT_ID'
        });

        $authProvider.instagram({
          clientId: 'YOUR_INSTAGRAM_CLIENT_ID'
        });
        
     
        
        $authProvider.oauth2({
            name: 'foursquare',
            url: '/auth/foursquare',
            clientId: 'MTCEJ3NGW2PNNB31WOSBFDSAD4MTHYVAZ1UKIULXZ2CVFC2K',
            redirectUri: window.location.origin || window.location.protocol + '//' + window.location.host +'/Creguru/oauthcallback',
            authorizationEndpoint: 'https://foursquare.com/oauth2/authenticate'
          });
    }
    
    

    run.$inject = ['$rootScope', '$location', '$cookieStore', '$http'];
    function run($rootScope, $location, $cookieStore, $http) {
        // keep user logged in after page refresh
        $rootScope.globals = $cookieStore.get('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
        }

        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            // redirect to login page if not logged in and trying to access a restricted page
        	//alert($location.path());
            var restrictedPage = $.inArray($location.path(), ['/login', '/register','','/','/profile','/oauthcallback','/blog','/jobs','/crew','/about','/pop']) === -1;
            var loggedIn = $rootScope.globals.currentUser;
            //alert('restrictedPage :'+restrictedPage);
            //alert('logged in user :'+loggedIn);
            if (restrictedPage && loggedIn == null) {
                $location.path('/login');
            }
        });
    }

})();