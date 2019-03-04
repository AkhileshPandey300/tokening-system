/**
 * 
 */
package com.pramati.bank.tokening.system.utils;

/**
 * @author pramati
 *
 */
public enum TokenStatus {

	OPEN {
		@Override
		public String toString() {
			return "OPEN";
		}
	},
	COMPLETED {
		@Override
		public String toString() {
			return "COMPLETED";
		}
	},
	CANCELLED {
		@Override
		public String toString() {
			return "CANCELLED";
		}
	}

}
