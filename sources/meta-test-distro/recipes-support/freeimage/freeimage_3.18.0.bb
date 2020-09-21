#####################################################################################
## Freeimage lib: dependency library for ArrayFire build
#####################################################################################

DESCRIPTION = "Freeimage library"
SECTION = "libs"

SRC_URI = "${SOURCEFORGE_MIRROR}/freeimage/FreeImage3180.zip"
SRC_URI[md5sum] = "f8ba138a3be233a3eed9c456e42e2578"
SRC_URI[sha256sum] = "f41379682f9ada94ea7b34fe86bf9ee00935a3147be41b6569c9605a53e438fd"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = " \
    file://license-fi.txt;md5=8e1438cab62c8f655288588dc43daaf6 \
    file://license-gplv2.txt;md5=1fbed70be9d970d3da399f33dae9cc51 \
    file://license-gplv3.txt;md5=b5c176c43d7fb06bf6dd56e79c490f5b \
"


TARGET_CXXFLAGS += "-Wno-narrowing"

TARGET_CC_ARCH += "${LDFLAGS}"

TARGET_CFLAGS += "-DPNG_ARM_NEON_OPT=0"

S = "${WORKDIR}/FreeImage"

do_configure() {
    sed -i -e /^CC/d \
           -e /^CXX\ /d \
           -e /^AR/d \
           -e /^INCDIR\ /d \
           -e /^INSTALLDIR\ /d \
           -e s:'-o root -g root'::g \
           -e /ldconfig/d \
    ${S}/Makefile.gnu

    sed -i -e /^CC/d \
           -e /^CXX\ /d \
           -e /^AR/d \
           -e /^INCDIR\ /d \
           -e /^INSTALLDIR\ /d \
           -e s:'-o root -g root'::g \
           -e /ldconfig/d \
    ${S}/Makefile.fip
}

do_compile(){
    oe_runmake
    oe_runmake -f Makefile.fip
}

do_install() {
    install -d ${D}${libdir}
    install -d ${D}${includedir}
    oe_runmake INSTALLDIR="${D}${libdir}" INCDIR="${D}${includedir}" install
    oe_runmake INSTALLDIR="${D}${libdir}" INCDIR="${D}${includedir}" -f Makefile.fip install
}

INSANE_SKIP_${PN} = "already-stripped dev-so"

FILES_${PN} += "${libdir}"
FILES_${PN} += "${includedir}"
FILES_SOLIBSDEV = "{libdir}/lib${BP}${SOLIBSDEV}"
