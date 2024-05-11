package io.appmetrica.analytics.expo

class CantGetContext(message: String = "cant get context"): Exception(message)
class ActivityNotAttached(message: String = "cant get activity"): Exception(message)