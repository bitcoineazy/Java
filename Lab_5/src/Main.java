import java.util.Locale;
import java.util.Scanner;

public class Main {



    enum DayOfWeek {
        //

        SATURDAY("Суббота") {
            public int getNumberOfWorkHours() {
                return 6;
            }
        },
        SUNDAY("Воскресенье") {
            public int getNumberOfWorkHours() {
                return 7;
            }
        },
        MONDAY("Понедельник") {
            public int getNumberOfWorkHours() {
                return 1;
            }
        },
        TUESDAY("Вторник") {
            public int getNumberOfWorkHours() {
                return 2;
            }
        },
        WEDNESDAY("Среда") {
            public int getNumberOfWorkHours() {
                return 3;
            }
        },
        THURSDAY("Четверг") {
            public int getNumberOfWorkHours() {
                return 4;
            }
        },
        FRIDAY("Пятница") {
            public int getNumberOfWorkHours() {
                System.out.println("Пятый день недели");
                return 5;
            }
        };

        private String representation;

        private DayOfWeek(String representation) {
            this.representation = representation;

        }

        String getRepresentation() {
            return representation;
        }

        //public abstract int getNumberOfWorkHours;

    }


    public static void main(String[] args)
    {
        DayOfWeek day = DayOfWeek.SATURDAY;
        Scanner in = new Scanner(System.in);
        day = DayOfWeek.valueOf(in.next().toUpperCase(Locale.ROOT));

        switch (day) {
            case SATURDAY -> {
                System.out.println("Saturday");
            }

            case SUNDAY -> {
                System.out.println("Sunday");
            }



            default -> {
                System.out.printf("This day %s%n", day);
            }
        }

        DayOfWeek[] days = DayOfWeek.values();

        for (DayOfWeek myDay:days) {
            System.out.println(myDay + " " + myDay.ordinal() + " " + myDay.getRepresentation());
        }
    }
}