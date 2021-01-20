package com.joboffers.candidates;

import com.joboffers.candidates.domain.entity.CandidateEntity;
import com.joboffers.candidates.domain.entity.EducationalInformationEntity;
import com.joboffers.candidates.domain.entity.ProfessionalInformationEntity;
import com.joboffers.candidates.domain.entity.TechnologyEntity;
import com.joboffers.candidates.service.model.Candidate;
import com.joboffers.candidates.service.model.EducationalInformation;
import com.joboffers.candidates.service.model.Gender;
import com.joboffers.candidates.service.model.ProfessionalInformation;
import com.joboffers.candidates.service.model.Technology;
import com.joboffers.candidates.service.model.builder.CandidateBuilder;
import com.joboffers.candidates.service.model.builder.EducationalInformationBuilder;
import com.joboffers.candidates.service.model.builder.ProfessionalInformationBuilder;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public final class TestObjectFactory {

    public static Candidate createEmptyCandidate() {
        return CandidateBuilder.aCandidate()
                .build();
    }

    public static Candidate createCandidate(
            final List<EducationalInformation> ei,
            final List<ProfessionalInformation> pi) {

        return CandidateBuilder.aCandidate()
                .withName("Patricia")
                .withBirthday(LocalDate.of(1990, 10, 10))
                .withGender(Gender.WOMAN)
                .withEmail("patricia@candidate.com")
                .withAddress("Valencia 124")
                .withLinkedin("linkedin.com/patricia")
                .withPhoneNumber("6223344")
                .withEducationalInformationList(ei)
                .withProfessionalInformationList(pi)
                .build();
    }

    public static CandidateEntity createEmptyCandidateEntity() {
        final CandidateEntity candidateEntity = new CandidateEntity();
        candidateEntity.setId(UUID.randomUUID());
        return candidateEntity;
    }

    public static CandidateEntity createCandidateEntity(
            final List<EducationalInformationEntity> ei,
            final List<ProfessionalInformationEntity> pi) {

        final CandidateEntity candidateEntity = new CandidateEntity();
        candidateEntity.setName("Patricia");
        candidateEntity.setBirthday(LocalDate.of(1990, 10, 10));
        candidateEntity.setGender(Gender.WOMAN);
        candidateEntity.setEmail("patricia@candidate.com");
        candidateEntity.setAddress("Valencia 124");
        candidateEntity.setLinkedIn("linkedin.com/patricia");
        candidateEntity.setPhoneNumber("6223344");
        candidateEntity.setEducationalInformationList(ei);
        candidateEntity.setProfessionalInformationList(pi);
        return candidateEntity;
    }

    public static EducationalInformation createEducationalInformation(
            final LocalDate startDate,
            final LocalDate endDate,
            final List<Technology> technologyList) {

        return EducationalInformationBuilder.anEducationalInformation()
                .withName("University")
                .withDescription("Informatics Engineering")
                .withStartDate(startDate)
                .withEndDate(endDate)
                .withCourse("Java programming")
                .withPlace("UPC")
                .withTechnologyList(technologyList)
                .build();
    }

    public static EducationalInformationEntity createEducationalInformationEntity(
            final LocalDate startDate,
            final LocalDate endDate,
            final List<TechnologyEntity> technologyList) {

        final EducationalInformationEntity educationalInformationEntity = new EducationalInformationEntity();
        educationalInformationEntity.setDescription("Informatics Engineering");
        educationalInformationEntity.setStartDate(startDate);
        educationalInformationEntity.setEndDate(endDate);
        educationalInformationEntity.setCourse("Java programming");
        educationalInformationEntity.setPlace("UPC");
        educationalInformationEntity.setTechnologyList(technologyList);
        return educationalInformationEntity;
    }

    public static ProfessionalInformation createProfessionalInformation(
            final LocalDate startDate,
            final LocalDate endDate,
            final List<Technology> technologyList) {

        return ProfessionalInformationBuilder.aProfessionalInformation()
                .withName("First company job")
                .withDescription("Informatics Engineering at a consultant company")
                .withStartDate(startDate)
                .withEndDate(endDate)
                .withNotes("Working as a Java programmer for 10 years")
                .withTechnologyList(technologyList)
                .build();
    }
}
