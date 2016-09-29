(function () {
    'use strict';

    angular
        .module('app')
        .controller('UserController', UserController);
    UserController.$inject = ['UserService', '$location', '$rootScope', 'FlashService','$scope'];
    function UserController(UserService, $location, $rootScope, FlashService, $scope) {
        var vm = this;
        vm.seluser=null;
        vm.save = save;
        vm.loadSelectedUserProfile = loadSelectedUserProfile;
        
        (function initController() {
        	//alert('here'+$rootScope.selectedUserId);
           // loadCurrentUser();
            //loadAllUsers();
            //loadAllUserProfiles();
        	if ($rootScope.selectedUserId !=null)
        			loadSelectedUserProfile();
            
        })();
        
        function save() {
            vm.dataLoading = true;
            var resp=angular.toJson(vm.user, 2);
            alert(resp);
           // vm.user.userProfile.phonenumber
            
            /*UserService.CreateUserProfile(vm.user)
                .then(function (response) {
                	//alert(response.success);
                    if (response.success) {
                        FlashService.Success('SAVE successful', true);
                        $location.path('/login');
                    } else {
                        FlashService.Error(response.message);
                        vm.dataLoading = false;
                    }
                });*/
        };
        
        
        function saveUserProfile() {
        	
        	//alert
        	
        };

        function loadSelectedUserProfile() {
        	
        	//alert($rootScope.selectedUserId);
            UserService.GetProfileByUsername($rootScope.selectedUserId,'N')
                .then(function (user) {
                	//alert(user);
                    vm.seluser = user;
                   // alert(vm.seluser.listOfUserProfile[0].backgroundImage);
                    if(vm.seluser.listOfUserProfile[0].backgroundImage == null || vm.seluser.listOfUserProfile[0].backgroundImage == '')
                    	vm.seluser.listOfUserProfile[0].backgroundImage='assets/theme/images/userheaderimage.jpg';
                    //alert(vm.seluser.firstname);
                });
        };

        function loadAllUsers() {
            UserService.GetAll()
                .then(function (users) {
                    vm.allUsers = users;
                });
        };
        
        function loadAllUserProfiles() {
            UserService.GetAllUserProfiles()
                .then(function (usersProfiles) {
                    vm.allUserProfiles = usersProfiles;
                });
        };

        function deleteUser(id) {
            UserService.Delete(id)
            .then(function () {
                loadAllUsers();
            });
        };
    }

})();