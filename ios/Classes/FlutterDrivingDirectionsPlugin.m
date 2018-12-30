#import "FlutterDrivingDirectionsPlugin.h"
#import <flutter_driving_directions/flutter_driving_directions-Swift.h>

@implementation FlutterDrivingDirectionsPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftFlutterDrivingDirectionsPlugin registerWithRegistrar:registrar];
}
@end
