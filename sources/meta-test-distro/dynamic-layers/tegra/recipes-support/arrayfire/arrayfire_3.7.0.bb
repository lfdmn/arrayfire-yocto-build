##########################################################################################
#
#   ArrayFire v3.7.0
#
##########################################################################################

DESCRIPTION = "Arrayfire library"
include arrayfire_3.7.0.inc
DEPENDS += "arrayfire-native cudnn freeimage tegra-libraries boost python-native" 
RDEPENDS_${PN} += "cudnn"
inherit cmake cuda


EXTRA_OECMAKE += " \
    -DAF_BUILD_CPU=OFF \
    -DAF_BUILD_CUDA=ON \
    -DAF_BUILD_OPENCL=OFF \
    -DAF_BUILD_EXAMPLES=OFF \
    -DAF_BUILD_TEST=OFF \
    -DAF_WITH_GRAPHICS=OFF \
    -DCMAKE_BUILD_TYPE=Release \
    -DNATIVE_BIN_DIR=${WORKDIR}/recipe-sysroot-native/usr/bin \
    -DCUDA_architecture_build_targets=6.2 \
    -DcuDNN_INCLUDE_DIRS=${WORKDIR}/recipe-sysroot/usr/include/ \
"

do_configure_prepend(){
    echo ${bindir}
    echo ${D}

    # This directory isn't created and causes some CMake failures
    mkdir -p ${WORKDIR}/recipe-sysroot/usr/share/cmake/Modules/

    # ArrayFire expects a different head file name
    ln -s -f ${WORKDIR}/recipe-sysroot/usr/include/cudnn_v7.h ${WORKDIR}/recipe-sysroot/usr/include/cudnn.h 
}

do_install() {
    # Include
    install -d ${D}/${includedir}/af
    cp -r ${S}/include/* ${D}/${includedir}
    install ${B}/include/af/version.h ${D}/${includedir}/af
    install ${B}/include/af/compilers.h ${D}/${includedir}/af

        
    # Libs
    install -d ${D}/${libdir}
    install ${B}/src/backend/cuda/libafcuda.so.${PV} ${D}/${libdir}
    ln -sf libafcuda.so.${PV} ${D}/${libdir}/libafcuda.so.3
    ln -sf libafcuda.so.3 ${D}/${libdir}/libafcuda.so
    install ${B}/src/api/unified/libaf.so.${PV} ${D}/${libdir}
    ln -sf libaf.so.${PV} ${D}/${libdir}/libaf.so.3
    ln -sf libaf.so.3 ${D}/${libdir}/libaf.so
}

# Arrayfire python requires libafcuda.so.3 and libafcuda.so, thus, we have to install them always and add the dev-so insane exception
INSANE_SKIP_${PN} += "rpaths dev-so"

# Defining packages
FILES_${PN} = "${libdir}/*"
FILES_${PN}-dev = "${includedir}/*"
