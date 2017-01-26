/**
 * @fileoverview
 * Provides methods for the Hello Endpoints sample UI and interaction with the
 * Hello Endpoints API.
 *
 * @author danielholevoet@google.com (Dan Holevoet)
 */

/** google global namespace for Google projects. */
var google = google || {};

/** devrel namespace for Google Developer Relations projects. */
google.devrel = google.devrel || {};

/** samples namespace for DevRel sample code. */
google.devrel.samples = google.devrel.samples || {};

/** hello namespace for this sample. */
google.devrel.samples.stackboo = google.devrel.samples.stackboo || {};

/**
 * Client ID of the application (from the APIs Console).
 * @type {string}
 */
google.devrel.samples.stackboo.CLIENT_ID = '703914324096';

/**
 * Scopes used by the application.
 * @type {string}
 */
google.devrel.samples.stackboo.SCOPES = 'https://www.googleapis.com/auth/userinfo.email';

/**
 * Whether or not the user is signed in.
 * @type {boolean}
 */
google.devrel.samples.stackboo.signedIn = false;

/**
 * Prints a greeting to the greeting log.
 * param {Object} greeting Greeting to print.
 */
google.devrel.samples.stackboo.print = function(Advisor) {
	var element = document.createElement('div');
	element.classList.add('row');
	element.innerHTML = Advisor.advisorId;
	document.getElementById('outputLog').appendChild(element);
};

/**
 * Gets a numbered greeting via the API.
 * @param {string} id ID of the greeting.
 */
google.devrel.samples.stackboo.advisorRead = function(id, password) {
	gapi.client.stockboo.advisors.read({
		'advisorId' : id
	}).execute(function(resp) {
		if (!resp.code) {
			if (password == resp.password) {
				//        		 var element = document.createElement('div');
				//        		  element.classList.add('row');
				//        		  element.innerHTML = "Sucesss";
				//        		  document.getElementById('outputLog').appendChild(element);

				window.location.href = "advisor.html";
			} else
				var element = document.createElement('div');
			element.classList.add('row');
			element.innerHTML = "Failure";
			document.getElementById('outputLog').appendChild(element);
		}
	});
};

google.devrel.samples.stackboo.advisorcreate = function(name, password, info,
		email, mobilenumber, superadmin, advisorblocked) {
	gapi.client.stockboo.advisors.create({
		'advisorBlocked' : advisorblocked,
		'email' : {
			'email' : email
		},
		'info' : info,
		'mobileNumber' : mobilenumber,
		'name' : name,
		'superAdmin' : superadmin,
		'password' : password
	}).execute(function(resp) {
		if (!resp.code) {
			var element = document.createElement('div');
			element.classList.add('row');
			element.innerHTML = "Successfully signed up";
			document.getElementById('outputLog').appendChild(element);
			//	  		window.location.href = "index.html";
		} else {
			var element = document.createElement('div');
			element.classList.add('row');
			element.innerHTML = "failure";
			document.getElementById('outputLog').appendChild(element);
			//		  		  window.location.href = "index.html";}
		}
	});
};

/**
 * Lists greetings via the API.
 */
/*google.devrel.samples.hello.listGreeting = function() {
 gapi.client.helloworld.greetings.listGreeting().execute(
 function(resp) {
 if (!resp.code) {
 resp.items = resp.items || [];
 for (var i = 0; i < resp.items.length; i++) {
 google.devrel.samples.stackboo.print(resp.items[i]);
 }
 }
 });
 };*/

/**
 * Gets a greeting a specified number of times.
 * @param {string} greeting Greeting to repeat.
 * @param {string} count Number of times to repeat it.
 */
/*google.devrel.samples.hello.multiplyGreeting = function(
 greeting, times) {
 gapi.client.helloworld.greetings.multiply({
 'message': greeting,
 'times': times
 }).execute(function(resp) {
 if (!resp.code) {
 google.devrel.samples.hello.print(resp);
 }
 });
 };*/

/**
 * Enables the button callbacks in the UI.
 */
google.devrel.samples.stackboo.enableButtons = function() {
	document.getElementById('advisorLogin').onclick = function() {
		alert('login clicked');
		google.devrel.samples.stackboo.advisorRead(document
				.getElementById('id').value,
				document.getElementById('mypass').value);
	}
};

/**
 * Enables the button callbacks in the UI.
 */
google.devrel.samples.stackboo.signButtons = function() {

	document.getElementById('advisorsignup').onclick = function() {
		var superadmin = document.getElementsByClassName('isSuperAdmin');
		var advisorblocked = document
				.getElementsByClassName('isAdvisorBlocked');
		if (superadmin.checked) {
			superadmin = "true";
			return superadmin;
		} else {
			superadmin = "false";
			return superadmin;
		}
		if (advisorblocked.checked) {
			advisorblocked = "true";
			return advisorblocked;
		} else {
			advisorblocked = "false";
			return advisorblocked;
		}

		google.devrel.samples.stackboo.advisorcreate(document
				.getElementById('name').value, document
				.getElementById('mypass').value, document
				.getElementById('email').value, document
				.getElementById('mobilenumber').value, superadmin,
				advisorblocked);
	}

};

/**
 * Initializes the application.
 * @param {string} apiRoot Root of the API's path.
 */
google.devrel.samples.stackboo.init = function(apiRoot) {
	// Loads the OAuth and helloworld APIs asynchronously, and triggers login
	// when they have completed.
	var apisToLoad;
	var callback = function() {
		if (--apisToLoad == 0) {
			google.devrel.samples.stackboo.enableButtons();
		}
	}

	apisToLoad = 2; // must match number of calls to gapi.client.load()
	gapi.client.load('stockboo', 'v1', callback, apiRoot);
	gapi.client.load('oauth2', 'v2', callback);
};

/**
 * 
 */
google.devrel.samples.stackboo.init2 = function(apiRoot) {
	// Loads the OAuth and helloworld APIs asynchronously, and triggers login
	// when they have completed.
	alert('inside create');
	var apisToLoad;
	var callback = function() {
		alert('inside function');
		if (--apisToLoad == 0) {
			google.devrel.samples.stackboo.signButtons();
		}
	}

	apisToLoad = 2; // must match number of calls to gapi.client.load()
	gapi.client.load('stockboo', 'v1', callback, apiRoot);
	gapi.client.load('oauth2', 'v2', callback);
};

/**
 * 
 */
google.devrel.samples.stackboo.crat = function(apiRoot) {
	// Loads the OAuth and helloworld APIs asynchronously, and triggers login
	// when they have completed.
	alert('inside stck create');
	var apisToLoad;
	var callback = function() {
		alert('inside stock function');
		if (--apisToLoad == 0) {
			google.devrel.samples.stackboo.stockcreateapi();
		}
	}

	apisToLoad = 2; // must match number of calls to gapi.client.load()
	gapi.client.load('stockboo', 'v1', callback, apiRoot);
	gapi.client.load('oauth2', 'v2', callback);
};

/**
 * Enables the button callbacks in the UI.
 */
google.devrel.samples.stackboo.stockcreateapi = function() {

	document.getElementById('stockcreate').onclick = function() {
		alert('stock craeate clicked');
		google.devrel.samples.stackboo.stockcreateapicall(document
				.getElementById('advisorId').value, document
				.getElementById('name').value, document
				.getElementById('scriptCode').value, document
				.getElementById('sugesstionType').value, document
				.getElementById('stopLoss').value, document
				.getElementById('targetPrice').value, document
				.getElementById('bookingPrice').value, document
				.getElementById('message').value, document
				.getElementById('status').value, document
				.getElementById('result').value);
	}

};

/**
 * Gets a numbered greeting via the API.
 * @param {string} id ID of the greeting.
 */
google.devrel.samples.stackboo.stockcreateapicall = function(advisorId, name,
		scriptCode, sugesstionType, stopLoss, targetPrice, bookingPrice,
		message, status, result) {
	alert('yet to  call rest');
	gapi.client.stockboo.stocks.create({
		'advisorId' : advisorId,
		'name' : name,
		'scriptCode' : scriptCode,
		'sugesstionType' : sugesstionType,
		'stopLoss' : stopLoss,
		'targetPrice' : targetPrice,
		'bookingPrice' : bookingPrice,
		'message' : message,
		'status' : status,
		'result' : result

	}).execute(function(resp) {
		if (!resp.code) {
			if (password == resp.password) {
				        		 var element = document.createElement('div');
				        		  element.classList.add('row');
				        		  element.innerHTML = "Sucesss";
				        		  document.getElementById('outputLog').appendChild(element);

//				window.location.href = "advisor.html";
			} else
				var element = document.createElement('div');
			element.classList.add('row');
			element.innerHTML = "Failure";
			document.getElementById('outputLog').appendChild(element);
		}
	});
};