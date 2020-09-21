SUMMARY = "Python arrayfire bindings"
DESCRIPTION = "Python arrayfire bindings"
HOMEPAGE = "http://github.com/gitpython-developers/GitPython"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/setup.py;beginline=9;endline=9;md5=05fd572c5dad2231458c336490765395"

SRC_URI = "git://github.com/arrayfire/arrayfire-python.git;protocol=https;branch=v3.6"
SRCREV = "c9cac8c6f3d72b386910b007ebbf765ead2daa3f"

S = "${WORKDIR}/git"

inherit setuptools3

export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

BBCLASSEXTEND = "native"

RDEPENDS_${PN} += "python3-core python3-ctypes python3-misc python3-numbers python3-threading python3-pkgutil python3-logging"
