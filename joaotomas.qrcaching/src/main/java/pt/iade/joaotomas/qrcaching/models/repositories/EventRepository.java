//package pt.iade.joaotomas.qrcaching.models;
//
//import java.util.ArrayList;
//
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class EventRepository {
//    public void EventItem() {
//        populate();
//
//    }
//
//    private final ArrayList<EventItem> eventList = new ArrayList<>();
//
//    private void populate() {
//        eventList.add(new EventItem(1, "Festa", 1, 1, null, null, null));
//        eventList.add(new EventItem(2, "Festa", 2, 2, null, null, null));
//        eventList.add(new EventItem(3, "Festa", 3, 3, null, null, null));
//        eventList.add(new EventItem(4, "Festa", 4, 4, null, null, null));
//        eventList.add(new EventItem(5, "Festa", 5, 5, null, null, null));
//        eventList.add(new EventItem(6, "Festa", 6, 6, null, null, null));
//        eventList.add(new EventItem(7, "Festa", 7, 7, null, null, null));
//
//    }
//
//    public ArrayList<EventItem> getAllEvents() {
//        return new ArrayList<>(eventList);
//    }
//
//    public EventItem getEventById(int id) {
//        for (EventItem event : eventList) {
//            if (event.getId() == id)
//                return event;
//        }
//        return null;
//    }
//
//    public EventItem addEvent(int id, String name, float latitude, float longitude, String localPhoto) {
//        EventItem event = new EventItem(id, name, latitude, longitude, null, null, localPhoto);
//        eventList.add(event);
//        return event;
//    }
//
//    public EventItem deleteEvent(int id) {
//        for (EventItem event : eventList) {
//            if (event.getId() == id) {
//                eventList.remove(event);
//                return event;
//            }
//        }
//        return null;
//    }
//    
//
//
//
//
//}

package pt.iade.joaotomas.qrcaching.models.repositories;

import java.util.ArrayList;
import java.util.List;
import pt.iade.joaotomas.qrcaching.models.EventItem;

public class EventRepository {

    private static final List<EventItem> eventList = new ArrayList<>();

    public static List<EventItem> getEvents() {
        return eventList;
    }

    public static EventItem getEvent(int id) {
        for (EventItem event : eventList) {
            if (event.getId() == id) {
                return event;
            }
        }
        return null;
    }

    public static boolean deleteEvent(int id) {
        EventItem eventToRemove = null;
        for (EventItem event : eventList) {
            if (event.getId() == id) {
                eventToRemove = event;
                break;
            }
        }
        if (eventToRemove != null) {
            eventList.remove(eventToRemove);
            return true;
        }
        return false;
    }

    public static void addEvent(EventItem event) {
        eventList.add(event);
    }
}

