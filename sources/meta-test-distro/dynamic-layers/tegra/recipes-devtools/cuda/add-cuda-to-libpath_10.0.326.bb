# Adds CUDA so libs to libpath
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
LICENSE = "CLOSED"

SRC_URI += " \
    file://cuda.conf \
"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

# Add missing symlinks required by arrayfire
do_install(){
    install -d -d ${D}${sysconfdir}/ld.so.conf.d/
    install -m 0644 ${WORKDIR}/cuda.conf ${D}${sysconfdir}/ld.so.conf.d/
}

FILES_${PN} = "${sysconfdir}/*"

BBCLASSEXTEND = "native"
