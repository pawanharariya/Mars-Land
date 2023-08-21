## Mars Land ##

Mars Land is a simple demo app using ViewModel & LiveData with Retrofit, Glide and Moshi in Kotlin.

This app demonstrates the following views and techniques:

* [Retrofit](https://square.github.io/retrofit/) to make api calls to an HTTP web service
* [Moshi](https://github.com/square/moshi) which handles the deserialization of the returned JSON to Kotlin data objects 
* [Glide](https://bumptech.github.io/glide/) to load and cache images by URL.
  
It leverages the following components from the Jetpack library:

* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
* [Data Binding](https://developer.android.com/topic/libraries/data-binding/) with binding adapters
* [Navigation](https://developer.android.com/topic/libraries/architecture/navigation/) with the SafeArgs plugin for parameter passing between fragments
## App Preview ##
<img alt="Mars Land App Preview 1" src="https://github.com/pawanharariya/Mars-Land/assets/43620548/30cb64df-bf12-4bda-8fed-a50d62f857d0" width=200>
<img alt="Mars Land App Preview 2" src="https://github.com/pawanharariya/Mars-Land/assets/43620548/f6d5244f-ee23-4217-85cb-d3548bb1e402" width=200>
<img alt="Mars Land App Preview 3" src="https://github.com/pawanharariya/Mars-Land/assets/43620548/e5f4da30-6e19-45e1-b520-c3a3521a186c" width=200>


## RESTful Services ##
REpresentational State Transfer Architecture is a common stateless Web architecture built using standard web components and protocols. Web services that offer this architecture are known as RESTful services. Following are some properties of RESTful Web services.

1. Requests to RESTful Web services are made in standardized way via URIs. These URIs are transferred to servers using Http protocol. Web browsers also work on Http protocol.

2. Http protocol contains an operation to tell the server what to do. Some common HTTP operations are GET for retrieving server data, POST/PUT for updating data, DELETE for deleting data from the server.

3. The server responses with formatted data in the common Web formats like XML or JSON.

4. The service also accepts query parameters as part of the URI. Query parameter is separated from the location of the service by a question mark, and multiple parameters are separated by & sign.
    ```
    https://github.com/pawanharariya?tab=repositories&sort=name
    ```

## Retrofit ##
Retrofit is a library that creates a network API based on the content of web services. It fetches data from web service and routes it through a separate converter library, that decodes the data and returns it in form of objects. Converter libraries convert the server response in useful formats, like JSON. Retrofit creates all necessary network layers and runs the requests on background threads, so they don't block the UI. To use Retrofit we create following components:

1. Retrofit object : It helps in creating APIs to communicate to server. It requires the base url of the server and a Convertor factory, that build the required Covertor.

2. Interface : It explains how Retrofit talks to web server using HTTP requests. Retrofit then creates an object that implements this interface with all of its methods. This is conceptually similar to DAO of ROOM. We expose Retrofit object using Singleton pattern since  service calls are expensive, and we need only one Retrofit service instance.

## Permissions ##

Permissions protect the privacy of an Android User. Apps must request permission to access sensitive user data, such as contacts or call logs or to use system features like Camera or Internet. The permissions are added using `<uses-permission>` tag in the Android Manifest file. Permissions like Internet access are normal permission. But accessing contacts or camera are sensitive permissions, and above API level 23, they are requested at runtime from the user, in addition to be declared in manifest. Highly sensitive special permissions like access to change system settings, can only be given by the user by going to system settings. If the runtime permission isn't granted or permission isn't declared in the manifest, trying to use the associated feature results in `SecurityException`.


## Glide ##

Displaying an Internet image includes downloading the image, buffering and decoding from compressed format to an image that can be used by Android. It should be cached either to an in-memory cache or storage-based cache or both. And, all this should happen in background thread so that UI remains responsive.

Glide library does all this and it just needs url and the ImageView. With Glide we can also display a placeholder image while the image is loading and an error image if the loading fails. This can be done using `RequestOptions()` object.

## Parcel and Parcelables ##

Parceling is a way of sharing objects between different processes by flattening an object into a stream of data called a parcel. Each value in the object is written in sequence to the parcel. This can be done by implementing the parcelable interface. A bundle is a parcelable object that contains key-value store of parcelable objects.

We use bundles as the argument property in fragments because of the way Android lifecycle works. When activity is destroyed, when the app running in background is killed. All information in SaveInstanceState has to be from parcelables, because it is used to recreate objects when the app gets restarted which is a new process. When activity is recreated, the fragment manager recreates all fragments, since the arguments are parcelable, bundles can be stored in SaveInstanceState. This allows fragments to preserve their arguments when the process is destroyed and fragment is recreated.