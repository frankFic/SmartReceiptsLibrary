package co.smartreceipts.android.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.TimeZone;

import android.os.Parcel;
import android.os.Parcelable;

public class Distance implements Parcelable {

	private String mLocation;
	private BigDecimal mDistance;
	private Date mDate;
	private String mTimezone;
	private BigDecimal mRate;
	private String mComment;

	public Distance() {
	}

	protected Distance(Parcel in) {
		mLocation = in.readString();
		mDistance = (BigDecimal) in.readValue(BigDecimal.class.getClassLoader());
		long tmpDate = in.readLong();
		mDate = tmpDate != -1 ? new Date(tmpDate) : null;
		mTimezone = in.readString();
		mRate = (BigDecimal) in.readValue(BigDecimal.class.getClassLoader());
		mComment = in.readString();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(mLocation);
		dest.writeValue(mDistance);
		dest.writeLong(mDate != null ? mDate.getTime() : -1L);
		dest.writeString(mTimezone);
		dest.writeValue(mRate);
		dest.writeString(mComment);
	}

	public String getLocation() {
		return mLocation;
	}

	public void setLocation(String location) {
		mLocation = location;
	}

	public BigDecimal getDistance() {
		return mDistance;
	}

	public void setDistance(BigDecimal distance) {
		mDistance = distance;
	}

	public Date getDate() {
		return mDate;
	}

	public void setDate(Date date) {
		mDate = date;
	}

	public String getTimezone() {
		return mTimezone;
	}

	public void setTimezone(String timezone) {
		mTimezone = timezone;
	}

	public BigDecimal getRate() {
		return mRate;
	}

	public void setRate(BigDecimal rate) {
		mRate = rate;
	}

	public String getComment() {
		return mComment;
	}

	public void setComment(String comment) {
		mComment = comment;
	}

	public static final class Builder {
		private String _location;
		private BigDecimal _distance;
		private Date _date;
		private String _timezone;
		private BigDecimal _rate;
		private String _comment;

		public Builder setLocation(String location) {
			_location = location;
			return this;
		}

		public Builder setDistance(BigDecimal distance) {
			_distance = distance;
			return this;
		}

		public Builder setDate(Date date) {
			_date = date;
			return this;
		}

		public Builder setTimezone(String timezone) {
			_timezone = timezone;
			return this;
		}

		public Builder setTimezone(TimeZone timezone) {
			_timezone = timezone.getID();
			return this;
		}

		public Builder setRate(BigDecimal rate) {
			_rate = rate;
			return this;
		}

		public Builder setComment(String comment) {
			_comment = comment;
			return this;
		}

		public Distance build() {
			Distance distance = new Distance();
			distance.setLocation(_location);
			distance.setDistance(_distance);
			distance.setDate(_date);
			distance.setTimezone(_timezone);
			distance.setRate(_rate);
			distance.setComment(_comment);
			return distance;
		}

	}

	public static final Parcelable.Creator<Distance> CREATOR = new Parcelable.Creator<Distance>() {
		@Override
		public Distance createFromParcel(Parcel in) {
			return new Distance(in);
		}

		@Override
		public Distance[] newArray(int size) {
			return new Distance[size];
		}
	};
}
