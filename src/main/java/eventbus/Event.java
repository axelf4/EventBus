package eventbus;

/** An Event that occurs; may hold additional information.
 * 
 * @author Axel Forsman <axelsfor@gmail.com> */
public interface Event {
	/** Returns whether this {@link Event} has been cancelled and won't get published to underlying handlers.
	 * 
	 * @return <tt>true</tt> if cancelled */
	public boolean cancelled();

	/** Stops the underlying handlers from receiving this event. */
	public void cancel();

	/** Returns the object that caused this {@link Event} <i>(optional operation)</i>.
	 * 
	 * @return the object that caused this Event
	 * @throws UnsupportedOperationException If the cause was unknown/specified. */
	public Object source();

	public static abstract class EventImpl implements Event {
		/** If to stop notifying underlying handlers. */
		public boolean cancelled;
		/** Optionally the object that caused this Event. */
		public Object source;

		@Override
		public boolean cancelled() {
			return cancelled;
		}

		@Override
		public void cancel() {
			cancelled = true;
		}

		@Override
		public Object source() {
			if (source == null) throw new UnsupportedOperationException("No source was declared.");
			return source;
		}
	}
}
