object HotelReservationService {

    def recommendHotel: Seq[Hotel] => String => String = { hotels =>
        input =>
            (parse andThen calcPrice(hotels) andThen selectHotel andThen (_.name)) (input)
    }

    def parse: String => Agenda = { input =>
        val arr = input.split(":")
        val customerType = CustomerType.fromString(arr.head.trim)
        val dates = arr.last.split(",").map(_.split("\\(|\\)")).map(ds => (ds.head.trim, ds.last.trim))
        Agenda(customerType, dates)
    }

    type Date = String
    type Day = String
    type Price = Double

    case class Agenda(customerType: CustomerType, dates: Seq[(Date, Day)])

    trait CustomerType

    object CustomerType {
        def fromString(str: String): CustomerType = str match {
            case "Regular" => Regular
            case "Rewards" => Rewards
            case x => throw new IllegalArgumentException(s"unknown customer type: $x")
        }
    }

    case object Regular extends CustomerType

    case object Rewards extends CustomerType


    def calcPrice: Seq[Hotel] => Agenda => Seq[(Hotel, Price)] = { hotels =>
        agenda => hotels.map(hotel => calcPriceSingle(hotel)(agenda))
    }

    def calcPriceSingle: Hotel => Agenda => (Hotel, Price) = { hotel =>
        agenda =>
            val customerType = agenda.customerType
            val price = agenda.dates.map { case (_, day) => DayType.fromDayToDayType(day) }.map {
                case Weekday if customerType == Regular => hotel.regularWeekdayPrice
                case Weekday if customerType == Rewards => hotel.rewardsWeekdayPrice
                case Weekend if customerType == Regular => hotel.regularWeekendPrice
                case Weekend if customerType == Rewards => hotel.rewardsWeekendPrice
            }.sum
            (hotel, price)
    }

    trait DayType
    object DayType {
        def fromDayToDayType: Day => DayType = {
            case ("mon" | "tues" | "wed" | "thu" | "fri") => Weekday
            case ("sat" | "sun") => Weekend
            case x => throw new IllegalArgumentException(s"unknown day: $x")
        }
    }

    case object Weekday extends DayType

    case object Weekend extends DayType

    case class Hotel(name: String, rating: Int,
                     regularWeekdayPrice: Price, rewardsWeekdayPrice: Price,
                     regularWeekendPrice: Price, rewardsWeekendPrice: Price)

    def selectHotel: Seq[(Hotel, Price)] => Hotel = _.sortWith {
        case ((hotel1, price1), (hotel2, price2)) =>
            if (price1 == price2) hotel1.rating > hotel2.rating else price1 < price2
    }.head._1
}
