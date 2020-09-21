FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
LICENSE = "CLOSED"

SRC_URI += " \
	file://20-gbe1.network \
"

do_install() {
	install -d ${D}${sysconfdir}/systemd/network
	install -m 0644 ${WORKDIR}/20-gbe1.network ${D}${sysconfdir}/systemd/network/
}


FILES_${PN} += " \
	{sysconfdir}/systemd/network/* \
"
