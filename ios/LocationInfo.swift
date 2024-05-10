
import ExpoModulesCore

struct LocationInfo: Record {
    @Field
    var latitude: Double = 0.0
    @Field
    var longitude: Double = 0.0
    @Field
    var altitude: Double? = nil
    @Field
    var accuracy: Float? = nil
    @Field
    var verticalAccuracy: Float? = nil
    @Field
    var course: Float? = nil
    @Field
    var speed: Float? = nil
    @Field
    var timestamp: Double? = nil

    func toLocation() -> CLLocation {
        let date = Date(timeIntervalSince1970: TimeInterval(timestamp!))
        let coordinate = CLLocationCoordinate2D(latitude: CLLocationDegrees(latitude), longitude: CLLocationDegrees(longitude))
        let location = CLLocation(coordinate: coordinate, altitude: CLLocationDistance(altitude!), horizontalAccuracy: CLLocationAccuracy(accuracy!), verticalAccuracy: CLLocationAccuracy(verticalAccuracy!), timestamp: date) 
        return location
    }
}