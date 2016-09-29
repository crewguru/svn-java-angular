(function () {
    'use strict';

    angular
        .module('app')
        .controller('UserProfleController', UserProfleController);
    UserProfleController.$inject = ['UserService', '$location', '$rootScope', 'FlashService','$scope','toastr'];
    function UserProfleController(UserService, $location, $rootScope, FlashService, $scope, toastr) {
        var vm = this;
        vm.user=null;
        vm.checkBox1=null;
        vm.workCategories=null;
        vm.industries=null;
        vm.save = save;
        vm.addLocation= addLocation;
        vm.addWorkExperience= addWorkExperience;
        vm.loadCurrentUserProfile = loadCurrentUserProfile;
        vm.getWorkCategory = getWorkCategory;
        vm.selectWorkCategory = selectWorkCategory;
        vm.getIndustry = getIndustry;
        vm.selectIndustry = selectIndustry;
        
        vm.workCategoriesSlected=[];
        vm.industriesSlected=[];
        vm.skillsSlected=[];
        vm.selectKill=null;
        vm.addSkill=addSkill;
        vm.removeSkill=removeSkill;
        
        $scope.skills = [
								{name:'Executive Producer', code:''},
							    {name:'Executive Creative Director', code:''},
							    {name:'Creative Director', code:''},
							    {name:'Art Director', code:''},
							    {name:'Senior Producer', code:''},
							    {name:'Producer', code:''},
							    {name:'Line Producer', code:''},
							    {name:'Production Manager', code:''},
							    {name:'Project Manager', code:''},
							    {name:'Production Assistant', code:''},
							    {name:'Stage Manager', code:''},
							    {name:'Backstage Manager', code:''},
							    {name:'Talent Coordinator', code:''},
							    {name:'Technical Director', code:''},
							    {name:'Render Artist', code:''},
							    {name:'CAD Engineer', code:''},
							    {name:'Structural Designer', code:''},
							    {name:'Structural Drafter', code:''},
							    {name:'Structural Detailer', code: ''},
							    {name:'Lighting Designer', code:''},
							    {name:'Master Electrician', code:''},
							    {name:'Assistant Lighting Tech', code:''},
							    {name:'Media Server Tech', code:''},
							    {name:'', code:''},
							    {name:'Audio', code:''},
							    {name:'', code:''},
							    {name:'Audio Mixer', code:''},
							    {name:'Audio Assistant', code:''},
							    {name:'RF Tech', code:''},
							    {name:'', code:''},
							    {name:'Video', code:''},
							    {name:'', code:''},
							    {name:'Projectionist', code:''},
							    {name:'Live Video Director', code:''},
							    {name:'Video Director', code:''},
							    {name:'Video Producer', code:''},
							    {name:'Video Playback Operator', code:''},
							    {name:'Projection Assistant', code:''},
							    {name:'Video Engineer', code:''},
							    {name:'Camera Operator', code:''},
							    {name:'Encore Operator', code:''},
							    {name:'Video Editor', code:''},
							    {name:'DP', code:''},
							    {name:'Director of Photography', code:''},
							    {name:'', code:''},
							    {name:'Additional Support', code:''},
							    {name:'', code:''},
							    {name:'Stage Hand', code:''},
							    {name:'Grip', code:''},
							    {name:'Electrician', code:''},
							    {name:'Craft Service ', code:''},
							    {name:'Rigger', code:''},
							    {name:'Hair / Make-Up Artist', code:''},
							    {name:'Photographer', code:''},
							    {name:'Composer', code:''},
							    {name:'', code:''},
							    {name:'Speaker Support', code:''},
							    {name:'', code:''},
							    {name:'Speaker Support Coordinator', code:''},
							    {name:'Speaker Support Operator', code:''},
							    {name:'Teleprompter Operator', code:''},
							    {name:'Graphic Designer', code:''},
							    {name:'Wide Screen Designer', code:''},
							    {name:'Wide-screen Operator', code:''},
							    {name:'Audience Response System Coordinator', code:''},
							    {name:'', code:''},
							    {name:'Set', code:''},
							    {name:'', code:''},
							    {name:'Set Designer', code:''},
							    {name:'Set Builder', code:''},
							    {name:'Carpenter', code:''},
							    {name:'Print Coordinator', code:''},
							    {name:'Installation Labor', code:''},
							    {name:'Décor Coordinator', code:''},
							    {name:'Furniture Coordinator', code:''},
							    {name:'Bartender', code:''},
							    {name:'Server', code:''},
							    {name:'Caterer', code:''},

							    {name:'Decor', code:''},

							    {name:'Event Designer', code:''},
							    {name:'Décor Professional', code:''},
							    {name:'Florist', code:''},
							    {name:'Floral Designer', code:''},
							    {name:'Lighting Designer', code:''},
							    {name:'Set Designer', code:''},
							    {name:'Set Builder', code:''},
							    {name:'Furniture Coordinator', code:''},
							    {name:'Laborer', code:''},

							    {name:'Talent and Craft', code:''},

							    {name:'Costumer', code:''},
							    {name:'Brand Ambassador', code:''},
							    {name:'Spokes Person', code:''},
							    {name:'Magician', code:''},
							    {name:'Presenter', code:''},
							    {name:'Palm Reader', code:''},
							    {name:'Fortune Teller', code:''},
							    {name:'Juggler', code:''},
							    {name:'Carnival Operator', code:''},
							    {name:'Actor', code:''},
							    {name:'Actress', code:''},
							    {name:'Acrobat', code:''},
							    {name:'Animal Handler', code:''},
							    {name:'Pianist', code:''},
							    {name:'Guitarist', code:''},
							    {name:'Musician', code:''},
							    {name:'Composer', code:''},
							    {name:'Harpist', code:''},
							    {name:'Bagpipe Player', code:''},
							    {name:'Choir Director', code:''},
							    {name:'Singer', code:''},
							    {name:'Extra', code:''},

							    {name:'Planning and Logistics', code:''},

							    {name:'Event Planner', code:''},
							    {name:'Event Manager', code:''},
							    {name:'Event Producer', code:''},
							    {name:'Event Creative Director', code:''},
							    {name:'Transportation Coordinator', code:''},
							    {name:'Render Artist', code:''},
							    {name:'Director', code:''},
							    {name:'Second Unit Director', code:''},
							    {name:'Executive Producer', code:''},
							    {name:'Producer', code:''},
							    {name:'Line Producer', code:''},
							    {name:'Production Manager/Production Supervisor', code:''},
							    {name:'Production Coordinator', code:''},
							    {name:'Assistant Director', code:''},
							    {name:'Second Assistant Director', code:''},
							    {name:'Production Accountant', code:''},
							    {name:'Production Accountant Assistant', code:''},
							    {name:'Script Supervisor', code:''},
							    {name:'Location Manager', code:''},
							    {name:'Assistant Location Manager', code:''},
							    {name:'Location Scout', code:''},
							    {name:'Location Production Assistant', code:''},
							    {name:'Key Production Assistant', code:''},
							    {name:'Production Assistant', code:''},
							    {name:'Runner', code:''},
							    {name:'Talent', code:''},
							    {name:'Casting Director', code:''},
							    {name:'Casting Assistant', code:''},
							    {name:'Choregrapher', code:''},
							    {name:'Choreography Assistant', code:''},
							    {name:'Camera', code:''},
							    {name:'Director of Photography (DP)', code:''},
							    {name:'Camera Operator', code:''},
							    {name:'Steadicam Operator', code:''},
							    {name:'Motion Control Operator (MOCO Operator)', code:''},
							    {name:'Drone Camera Operator', code:''},
							    {name:'Helicopter Photographer', code:''},
							    {name:'First Assistant Camera', code:''},
							    {name:'Second/Third Assistant Camera', code:''},
							    {name:'Digital Imaging Technician (DIT)', code:''},
							    {name:'Digital Imaging Technician (DIT) - Assistant', code:''},
							    {name:'Film Loader/Clapper Loader', code:''},
							    {name:'Lighting', code:''},
							    {name:'Gaffer', code:''},
							    {name:'Best Boy (Lighting)', code:''},
							    {name:'Lighting Technician', code:''},
							    {name:'Electrician', code:''},
							    {name:'Swing', code:''},
							    {name:'Grip', code:''},
							    {name:'Key Grip', code:''},
							    {name:'Best Boy (Grip)', code:''},
							    {name:'Dolly Grip', code:''},
							    {name:'Rigger', code:''},
							    {name:'Grip', code:''},
							    {name:'Swing', code:''},
							    {name:'Utility', code:''},
							    {name:'Wrap Utility', code:''},
							    {name:'Video', code:''},
							    {name:'Video Assist Operator', code:''},
							    {name:'Audio', code:''},
							    {name:'Production Sound Mixer', code:''},
							    {name:'Boom Operator', code:''},
							    {name:'Second Assistant Sound', code:''},
							    {name:'Art Department', code:''},
							    {name:'Production Designer', code:''},
							    {name:'Art Director', code:''},
							    {name:'Standby Art Director (UK)', code:''},
							    {name:'Assistant Art Director', code:''},
							    {name:'Illustrator', code:''},
							    {name:'Graphic Artist', code:''},
							    {name:'Art Department Assistant', code:''},
							    {name:'Set Department', code:''},
							    {name:'Set Decorator', code:''},
							    {name:'Lead Man', code:''},
							    {name:'Set Dresser', code:''},
							    {name:'Scenic', code:''},
							    {name:'Carpenter', code:''},
							    {name:'Painter', code:''},
							    {name:'Greensman', code:''},
							    {name:'Greensman Assistant', code:''},
							    {name:'Set Production Assistant', code:''},
							    {name:'Props Department', code:''},
							    {name:'Property Master (Prop Master)', code:''},
							    {name:'Buyer', code:''},
							    {name:'Property Assistant (Props Assistant)', code:''},
							    {name:'Weapons Master', code:''},
							    {name:'Weapons Assistant', code:''},
							    {name:'Costume Department', code:''},
							    {name:'Stylist (Costume Designer)', code:''},
							    {name:'Key Costumer', code:''},
							    {name:'Costume Assistant', code:''},
							    {name:'Seamstress', code:''},
							    {name:'Transportation', code:''},
							    {name:'Transportation Coordinator', code:''},
							    {name:'Transportation Assistant', code:''},
							    {name:'Driver', code:''},
							    {name:'Animals', code:''},
							    {name:'Animal Wrangler', code:''},
							    {name:'Animal Trainer', code:''},
							    {name:'Animal Groomer', code:''},
							    {name:'Make Up/Hair Deparment', code:''},
							    {name:'Key Make Up Artist', code:''},
							    {name:'Make Up Artist', code:''},
							    {name:'Make Up Supervisor', code:''},
							    {name:'Special Effects Make Up', code:''},
							    {name:'Make Up Prosthetic', code:''},
							    {name:'Key Hair', code:''},
							    {name:'Hair Stylist', code:''},
							    {name:'Wig Assistant', code:''},
							    {name:'Stunts', code:''},
							    {name:'Stunt Coordinator', code:''},
							    {name:'Stunt Driver', code:''},
							    {name:'Stunt Weapons Expert', code:''},
							    {name:'Stunt Assistant', code:''},
							    {name:'Special Effects - Physical', code:''},
							    {name:'Special Effects Supervisor', code:''},
							    {name:'Special Effects Assistant', code:''},
							    {name:'Special Effects - Visual', code:''},
							    {name:'Special Effects Supervisor', code:''},
							    {name:'Special Effects Assistant', code:''},
							    {name:'Post Production', code:''},
							    {name:'Post Production Supervisor', code:''},
							    {name:'Editor', code:''},
							    {name:'Assistant Editor', code:''},
							    {name:'Colorist', code:''},
							    {name:'Visual Effects Producer', code:''},
							    {name:'Visual Effects Creative Director', code:''},
							    {name:'Visual Effects Supervisor', code:''},
							    {name:'Visual Effects Editor', code:''},
							    {name:'Compositor', code:''},
							    {name:'Rotoscope Artist', code:''},
							    {name:'Matte Painter', code:''},
							    {name:'Sound Department', code:''},
							    {name:'Sound Designer', code:''},
							    {name:'Composer', code:''},
							    {name:'Sound Mixer', code:''},
							    {name:'Sound Editor', code:''},
							    {name:'Dialogue Editor', code:''},
							    {name:'Music Supervisor', code:''},
							    {name:'Music Editor', code:''},
							    {name:'Foley Artist', code:''},
							    {name:'Re-Recording Mixer', code:''},
							    {name:'Animation', code:''},
							    {name:'Animation Director', code:''},
							    {name:'Animation Producer', code:''},
							    {name:'Animation Character Developer', code:''},
							    {name:'Animator', code:''},
							    {name:'CG Artist (2D)', code:''},
							    {name:'CG Artist (3D)', code:''},
							    {name:'Compositor', code:''},
							    {name:'Digital Painter', code:''},
							    {name:'Stop Motion Artist', code:''},
							    {name:'Head of Model Making', code:''},
							    {name:'Model Maker', code:''},
							    {name:'Inbetweener', code:''}

                          ];
        
        



        


        
        (function initController() {
        	//alert('here'+$rootScope.selectedUserId);
           // loadCurrentUser();
            //loadAllUsers();
            //loadAllUserProfiles();
        	//if ($rootScope.selectedUserId !=null)
        	//alert('init is called...'+vm.workCategoriesSlected);
        	vm.workCategoriesSlected=[];
        	vm.industriesSlected=[];
        	loadCurrentUserProfile();
        	vm.getWorkCategory();
        	vm.getIndustry();
        	//addWorkExperience();
            
        })();
        
        
        
        function save() {
            vm.dataLoading = true;
            //alert(vm.user.listOfLocation[0].city);
            //alert(vm.user.listOfLocation[1].city);
            var resp=angular.toJson(vm.user, 2);
            console.log(resp);
           // vm.user.userProfile.phonenumber
            
            UserService.SaveUserProfile(vm.user)
                .then(function (response) {
                	//alert(response.success);
                    if (response.success) {
                        FlashService.Success('SAVE successful', true);
                        //toastr.success('Your profile has been saved');
                        $location.path('/');
                    } else {
                        FlashService.Error(response.message);
                        vm.dataLoading = false;
                    }
                });
        };
        
        function getWorkCategory()
        {
        	vm.workCategories = [ { "name": "Crew", "id": "1" } , {"name": "Corporate Client", "id": "3" },{"name": "Service Company", "id": "2" } ];
        };
        
        function getIndustry()
        {
        	vm.industries = [ { "name": "Meetings and Events", "id": "1" } , 
        	                      {"name": "Motion Picture / Television / Video Production", "id": "2" },
        	                      {"name": "Performing Arts", "id": "3" },
        	                      {"name": "Broadcast Commercial", "id": "4" },
        	                      {"name": "Photography", "id": "5" }
        	                    ];
        };
        
        function selectWorkCategory(wcategoryid)
        {
        	
        	//alert('hereee');
        	var idx = vm.workCategoriesSlected.indexOf(wcategoryid);

            // is currently selected
            if (idx > -1) {
            	vm.workCategoriesSlected.splice(idx, 1);
            }

            // is newly selected
            else {
            	vm.workCategoriesSlected.push(wcategoryid);
            }
            
            vm.user.listOfUserProfile[0].workCategory=vm.workCategoriesSlected.join(',');
            
        	
        };
        
        
        function selectIndustry(industryid)
        {
        	
        	//alert('hereee');
        	var idx = vm.industriesSlected.indexOf(industryid);

            // is currently selected
            if (idx > -1) {
            	vm.industriesSlected.splice(idx, 1);
            }

            // is newly selected
            else {
            	vm.industriesSlected.push(industryid);
            }
            
            vm.user.listOfUserProfile[0].industry=vm.industriesSlected.join(',');
            
        	
        };
        
        $scope.selectedSkill = function(selected) {
		      if (selected) {
		    	  vm.selectKill= selected.title;
		      } else {
		    	  vm.selectKill=null;
		        console.log('cleared');
		      }
		      //alert(vm.selectKill);
		 };
		 
		 function removeSkill(skill)
		 {
			 //alert('here');
			 var idx = vm.skillsSlected.indexOf(skill);
			 //alert(idx);
	            // is currently selected
	            if (idx > -1) {
	            	vm.skillsSlected.splice(idx, 1);
	            	vm.user.listOfUserProfile[0].skills=vm.skillsSlected.join(',');
	            }
	           // alert(vm.skillsSlected);
		 }
		 
		 function addSkill()
		 {
			 //alert('here '+vm.selectKill);
			 if(vm.selectKill !=null)
			{
				 //alert('here '+idx);
				 var idx = vm.skillsSlected.indexOf(vm.selectKill);
				 
				// alert('here '+idx);

		            // is currently selected
		            if (idx < 0) {
		            	//alert('here ');
		            	vm.skillsSlected.push(vm.selectKill);
		            	//alert(vm.skillsSlected);
		            	vm.user.listOfUserProfile[0].skills=vm.skillsSlected.join(',');
		            	vm.selectKill=null;
		            	 
		            }
		            
		           
			}	
			 $scope.$broadcast('angucomplete-alt:clearInput');
		 }
        
        function addLocation()
        {
        	//alert('here');
        	var newLocation = new function() {
                this.id = null;
                this.userId    = vm.user.userId;
                this.city          = '';
                this.state          = '';
                this.type          = "F";
                this.country          = '';
                this.zip          = '';
            }
        	
        	
        	var currentList = vm.user.listOfLocation;
        	var newList = currentList.concat(newLocation);
        	vm.user.listOfLocation = newList;
        	//$rootScope.$apply();
        	 //var resp=angular.toJson(vm.user.listOfLocation, 2);
             //alert(resp);
        };
        
        function addWorkExperience()
        {
        	//alert('here');
        	var newWorkExp = new function() {
                this.id = null;
                this.userId    = vm.user.userId;
                this.company          = '';
                this.description          = '';
                this.jobtitle          = "";
                this.fromDate          = '';
                //this.zip          = '';
            }
        	
        	
        	var currentList = vm.user.listOfWorkExperience;
        	var newList = currentList.concat(newWorkExp);
        	vm.user.listOfWorkExperience = newList;
        	
        };
        
        
        
        
        function saveUserProfile() {
        	
        	//alert
        	
        };

        function loadCurrentUserProfile() {
        	
        	//alert($rootScope.selectedUserId);
            UserService.GetProfileByUsername($rootScope.globals.currentUser.username,'Y')
                .then(function (user) {
                	//alert(user);
                	//alert(user.listOfLocation.length);
                    vm.user = user;
                    if(vm.user.listOfUserProfile[0].workCategory !=null && vm.user.listOfUserProfile[0].workCategory != '')
                    	vm.workCategoriesSlected = vm.user.listOfUserProfile[0].workCategory.split(',');
                    if(vm.user.listOfUserProfile[0].industry !=null && vm.user.listOfUserProfile[0].industry != '')
                    	vm.industriesSlected = vm.user.listOfUserProfile[0].industry.split(',');
                    if(vm.user.listOfUserProfile[0].skills !=null && vm.user.listOfUserProfile[0].skills != '')
                    	vm.skillsSlected=vm.user.listOfUserProfile[0].skills.split(',');
                    //log.console(vm.user);
                });
        };

        
    }

})();