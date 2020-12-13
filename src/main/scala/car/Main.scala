package car

import zio._
import zio.console._
import car.internals._

object Main extends App {
  override def run(args: List[String]): URIO[ZEnv, ExitCode] = (for {
    engine <- ZIO.access[Engine](_.get)
    _ <- engine.start
  } yield ()).exitCode.provideCustomLayer(getEnv(args))

  protected def getEnv(args: List[String]) = {
    Engine.live ++ Transmission.live ++ Steering.live
  }
}
