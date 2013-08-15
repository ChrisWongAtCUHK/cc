package cuhk.cse;

public interface ILockable {
	public void lock();
	public void unlock();
	public boolean isLocked();
}