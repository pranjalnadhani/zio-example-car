package car

import zio.Has

package object internals {
  type Engine = Has[Engine.Service]
  type Transmission = Has[Transmission.Service]
  type Steering = Has[Steering.Service]
}
