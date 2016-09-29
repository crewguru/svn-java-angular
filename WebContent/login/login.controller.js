(function () {
    'use strict';

    angular
        .module('app')
        .controller('LoginController', LoginController);

    LoginController.$inject = ['$location', 'AuthenticationService', 'FlashService','$auth','toastr'];
    function LoginController($location, AuthenticationService, FlashService,$auth, toastr) {
        var vm = this;
        
        vm.login = login;
        vm.authenticate = authenticate;

        (function initController() {
            // reset login status
            AuthenticationService.ClearCredentials();
        })();

        function login() {
            vm.dataLoading = true;
            AuthenticationService.Login(vm.username, vm.password, function (response) {
            	//alert(response);
            	var user=response;
            	//alert(user);
            	if( user == 'undefined' || user == null ){
            		alert ('here');
            		FlashService.Error("Log in failed! Please input your correct credentials");
                    vm.dataLoading = false;
            	}
            	else
            	{
            		var profileImage='';
            		var bgImage='assets/theme/images/userheaderimage.jpg';
            	
            			if( user.listOfUserProfile.length > 0 ){
            				profileImage=user.listOfUserProfile[0].profileImage;
            				if( user.listOfUserProfile[0].backgroundImage !=null && user.listOfUserProfile[0].backgroundImage != '')
            					bgImage=user.listOfUserProfile[0].backgroundImage;
            			}
            		 AuthenticationService.SetCredentials(vm.username, vm.password,profileImage, bgImage, user.firstname);
                     $location.path('/');
            	}
                /*if (response.success) {
                   
                } else {
                    
                }*/
            });
        };
        
        function authenticate(provider) {
            vm.dataLoading = true;
            var profilePic=null;
            var bgImage='assets/theme/images/userheaderimage.jpg';
            $auth.authenticate(provider)
            .then(function(response) {
            		//alert(response);
            		var user=response.data;
            		//alert(user.listOfUserProfile);
              if( user == 'undefined' || user == null ){
            	  toastr.error(" Authentication Failed! Try again with correct credentials");
              }else{
            	  toastr.success('You have successfully signed in with ' + provider + '!');
            	  if(user.listOfUserProfile.length > 0 )
            	  {
            		  profilePic=user.listOfUserProfile[0].profileImage;
            		  if( user.listOfUserProfile[0].backgroundImage !=null && user.listOfUserProfile[0].backgroundImage != '')
            			  bgImage=user.listOfUserProfile[0].backgroundImage;
            	  }
                  AuthenticationService.SetCredentials(user.userId, user.password,profilePic,bgImage, user.firstname);
                  $location.path('/');
              }
              
            })
            .catch(function(error) {
            	//alert('here..'+error);
            	//alert('here.1.'+error.message);
            	//alert('here2..'+error.data);
              if (error.message) {
                // Satellizer promise reject error.
            	  //alert("here");
                toastr.error(error.message);
              } else if (error.data) {
            	 // alert("here1");
                // HTTP response error from server
                toastr.error(error.data.message, error.status);
              } else {
            	  //alert("here2");
                toastr.error(error);
              }
            });
            
            
            
        };
    }

})();
