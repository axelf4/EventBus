package eventbus;

/** Callback SAM (Single Abstract Method)-interface for subscribed {@link Event}s.
 * 
 * @author Axel Forsman <axelsfor@gmail.com> */
public interface Handler {
	/** Handles the published {@code event}. Returns <tt>false</tt> if this {@link Handler} isn't subscribing to {@link Event}s of
	 * {@linkplain Event#getClass() <code>event</code>'s class}, e.g.
	 * 
	 * <pre>
	 * public boolean handle(Event event) {
	 *  if (event instanceof Event.Tick) { ... }
	 *  else return false;
	 *  return true;
	 * }
	 * </pre>
	 * 
	 * @param event the {@link Event} published
	 * @return <tt>true</tt> if subscribing to event */
	public boolean handle(Event event);
}
