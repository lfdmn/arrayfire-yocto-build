##########################################################################################
#
#   ArrayFire v3.7.0
#
##########################################################################################

DESCRIPTION = "Arrayfire library bin2cpp package"

include arrayfire_3.7.0.inc
inherit native cmake

BUILD_CPPFLAGS += " \
    -std=c++14 \
"

do_configure(){
    cd ${B}
    cmake ${S} -DAF_BIN2CPP_ONLY=ON
}

do_compile(){
    make bin2cpp
}

do_install() {
    # Include
    install -d ${D}${bindir}/
    install -m 755 ${B}/bin2cpp ${D}${bindir}

    # Substitue hardcoded bin2cpp path to fix build failure when using mirrors
    sed -i 's/\".*\/bin2cpp\"/\"${CMAKE_CURRENT_LIST_DIR}\/bin2cpp\"/g' ${B}/ImportExecutables.cmake

    install -m 644 ${B}/ImportExecutables.cmake ${D}${bindir}
}


# Defining packages
FILES_${PN} = "${bindir}/*"

