/**
 * 
 */
package com.pramati.bank.tokening.system.utils;

/**
 * @author akhileshp
 *
 */
public enum CustomerType {

	PRIMIUM {
		@Override
		public String toString() {
			return "primium";
		}
	},
	REGULAR {
		@Override
		public String toString() {
			return "regular";
		}
	}
}
