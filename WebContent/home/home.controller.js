(function () {
    'use strict';

    angular
        .module('app')
        
        .controller('HomeController', HomeController);
    	

    HomeController.$inject = ['UserService', '$rootScope','$location','intialStartFilter'];
    function HomeController(UserService, $rootScope, $location, intialStartFilter) {
        var vm = this;
        $rootScope.selectedUserId='';
        vm.user = null;
        
        vm.currentPage = 0;
        vm.pageSize = 10;
        
        
        vm.allUserProfiles = [];
        vm.allUsers= [];
        vm.deleteUser = deleteUser;
        vm.callUserProfile = callUserProfile;
        vm.numberOfPages = numberOfPages;
        
       

        initController();

        function initController() {
            //loadCurrentUser();
            //loadAllUsers();
            loadAllUserProfiles();
            
        }
        
        function numberOfPages(){
            return Math.ceil(vm.allUserProfiles.length/vm.pageSize);                
        }
        
        function callUserProfile(userid)
        {
        	$rootScope.selectedUserId=userid;
        	$location.path('/profile');
        }

        function loadCurrentUser() {
        	
        	if( $rootScope.globals.currentUser !=null && $rootScope.globals.currentUser.username !=null)
        	{
        		 UserService.GetByUsername($rootScope.globals.currentUser.username)
                 .then(function (user) {
                     vm.user = user;
                 });
        	}
           
        }

        function loadAllUsers() {
            UserService.GetAll()
                .then(function (users) {
                    vm.allUsers = users;
                });
        }
        
        function loadAllUserProfiles() {
            UserService.GetAllUserProfiles()
                .then(function (usersProfiles) {
                    vm.allUserProfiles = usersProfiles;
                });
        }

        function deleteUser(id) {
            UserService.Delete(id)
            .then(function () {
                loadAllUsers();
            });
        }
    };
    
    
   

})();

