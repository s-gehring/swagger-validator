package gehring.simon.hobby.swagger.testing.generator;

public interface NumberGenerator {
	public boolean nextBoolean();

	public byte nextByte(byte low, byte high);

	public double nextDouble(double low, double high);

	public float nextFloat(float low, float high);

	public int nextInt(int low, int high);

	public long nextLong(long low, long high);

	public short nextShort(short low, short high);
}
