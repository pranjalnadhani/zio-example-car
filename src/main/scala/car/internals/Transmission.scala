package car.internals

import zio.{UIO, ZIO, ZLayer, ZManaged}

object Transmission {

  def live: ZLayer[Any, Nothing, Transmission] = Live.make.toLayer

  trait Service {
    def shiftUp: ZIO[Any, Nothing, Unit]

    def shiftDown: ZIO[Any, Nothing, Unit]

    def shiftTo(gear: Int): ZIO[Any, Nothing, Unit]
  }

  final class Live extends Service {
    override def shiftUp: ZIO[Any, Nothing, Unit] = ???

    override def shiftDown: ZIO[Any, Nothing, Unit] = ???

    override def shiftTo(gear: Int): ZIO[Any, Nothing, Unit] = ???
  }

  object Live {
    def make: ZManaged[Any, Nothing, Service] = UIO(new Live()).toManaged_
  }

}
